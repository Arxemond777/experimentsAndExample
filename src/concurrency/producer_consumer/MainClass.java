package concurrency.producer_consumer;

import concurrency.AbstractRunnable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainClass {
    public static final int MAX_CAPACITY = 10;

    private static void fillThreads(SystemSettings systemSettings, Class<? extends AbstractRunnable> abstractRunnable) {
        AtomicLong number = new AtomicLong();
        IntStream.range(0, systemSettings.count)
                .forEach(c -> {
                    try {
                        // find by name and init constructor
                        Class<?> clazz = Class.forName(abstractRunnable.getName());
                        Constructor<?> ctor = clazz.getConstructor(Queue.class, AtomicLong.class, int.class, String.class);
                        Object object = ctor.newInstance(
                                queue,
                                atomicLong,
                                systemSettings.delay,
                                abstractRunnable.getSimpleName() + ": " + number.incrementAndGet()
                        );

                        threads.add((AbstractRunnable) object);
                    } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }

    public static void main(String[] args) {
        Thread daemon = new Thread(() -> {
            while (true) {
                System.out.println("I`m daemon thread date: {" + LocalDateTime.now() + "}");
                int min = 1;

                try {
//                    TimeUnit.SECONDS.sleep(new Random().nextInt(min + 5) + min);
                    TimeUnit.SECONDS.sleep(new SecureRandom().nextInt(min + 5) + min);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        daemon.setDaemon(true);
        daemon.start();

        fillThreads(SystemSettings.PRODUCER, Producer.class);
        fillThreads(SystemSettings.CONSUMER, Consumer.class);

        ExecutorService executorService = Executors.newFixedThreadPool(SystemSettings.getTotalCount());
        threads.forEach(executorService::submit);
    }

    private enum SystemSettings {
        CONSUMER(1, 500), PRODUCER(5, 0);
        private final int count, delay;

        SystemSettings(int count, int delay) {
            this.count = count;
            this.delay = delay;
        }

        public int getCount() {
            return count;
        }

        public int getDelay() {
            return delay;
        }

        public static int getTotalCount() {
            return Stream.of(SystemSettings.values()).mapToInt(SystemSettings::getCount).sum();
        }
    }

    private static List<AbstractRunnable> threads = new ArrayList<>(SystemSettings.getTotalCount());

    private static AtomicLong atomicLong = new AtomicLong();
    private final static Queue<Long> queue = new ArrayBlockingQueue<>(MAX_CAPACITY);

}
