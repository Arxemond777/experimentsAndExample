package dynamic_resize_blocking_queue;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.System.lineSeparator;

public class DynamicResizeBlockingQueue {
    private static AtomicLong atomicLong = new AtomicLong();

    private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) throws InterruptedException {
        try {
            new DynamicResizeBlockingQueueExample(scheduledExecutorService);
        } finally {
            scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS);
            scheduledExecutorService.shutdownNow();
        }
    }
}

class DynamicResizeBlockingQueueExample {
    private final int DEFAULT_VALUE = 10;
    private final int PRODUCER_DELAY = 100;
    private final int MAX_SLEEP_WORK_FOR_ITASK = 1500;
    private final int MAX_TIME_FOR_WAIT_CONSUMER = MAX_SLEEP_WORK_FOR_ITASK / 3;
    private final int TIME_REFRESH_IN_SECOND = 10 * 1000; // 10 sec
    private final AtomicLong COUNT_OF_EXCEPTION = new AtomicLong();
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final ScheduledExecutorService scheduler;

    private BlockingQueue<ITask> blockingQueue = new ArrayBlockingQueue<>(DEFAULT_VALUE);

    DynamicResizeBlockingQueueExample(ScheduledExecutorService scheduler) {
        this.scheduler = scheduler;
    }


    public void doWork() {
        runBlockingQueueUpdateHandler(); // handler

        producer(); // run producer

        consumer(); // run consumer
    }

    private void consumer() {
        /**
         scheduleAtFixedRate() - don`t take into account the time of the tasks execution
            start every 1 second and perform 2 seconds
            |--2-execute--|-1-idle-|
                    |--2-execute--|-1-idle-|
                           |--2-execute--|-1-idle-|
                                  |--2-execute--|-1-idle-|

         so, after some time your queue will been overflow
          */

        scheduler.scheduleWithFixedDelay(() -> {
                    readWriteLock.readLock().lock();

                        try {
                            blockingQueue.poll(MAX_TIME_FOR_WAIT_CONSUMER, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException ie) {
                            COUNT_OF_EXCEPTION.incrementAndGet(); // increment counter of exception

                            System.out.println("Consumer: " + ie.getMessage());
                        }  finally { // if TimeoutException
                    readWriteLock.readLock().unlock();
                        }
                },
                TIME_REFRESH_IN_SECOND, TIME_REFRESH_IN_SECOND, TimeUnit.MILLISECONDS);

    }

    private void producer() {
        IntStream.range(0, MAX_VALUE) // producer
                .forEach(index -> {
                    readWriteLock.readLock().lock();
                        try {
                            blockingQueue.put(new Task(index, MAX_SLEEP_WORK_FOR_ITASK));
                            System.out.printf("%d has been put success" + lineSeparator(), index);
                        } catch (InterruptedException ie) {
                            System.out.println("Producer: " + ie.getMessage());
                        } finally { // if TimeoutException
                    readWriteLock.readLock().unlock();
                        }

                    try {
                        TimeUnit.MILLISECONDS.sleep(PRODUCER_DELAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

    public void runBlockingQueueUpdateHandler() {
        scheduler.scheduleWithFixedDelay(() -> {
            readWriteLock.writeLock().lock();
            try {
                int newSize = blockingQueue.size() +  Math.toIntExact(COUNT_OF_EXCEPTION.get());

                COUNT_OF_EXCEPTION.set(0L); // reset the counter

                blockingQueue = new ArrayBlockingQueue<>(newSize);
            } finally {
                readWriteLock.writeLock().unlock();
            }
        },
                TIME_REFRESH_IN_SECOND, TIME_REFRESH_IN_SECOND, TimeUnit.MILLISECONDS);
    }
}

class Task implements ITask {
    private final int SLEEP_TIME_RANDOM;
    private final String name;

    public Task(int number, int maxSleepWork) {
        this.SLEEP_TIME_RANDOM = new Random().nextInt(maxSleepWork);

        name = this.getClass().getName() +
                ": " + number + lineSeparator() +
                " | sleepTimeRandom: " + SLEEP_TIME_RANDOM;
    }

    @Override
    public long doLongCalculate() {
        try {
            TimeUnit.MILLISECONDS.sleep(SLEEP_TIME_RANDOM);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("I`ve performed %s" + lineSeparator(), this.name);

        return SLEEP_TIME_RANDOM;
    }
}

interface ITask {
    long doLongCalculate();
}