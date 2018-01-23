package concurrency.producer_consumer;

import concurrency.AbstractRunnable;
import concurrency.producer_consumer.MainClass;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public class Producer extends AbstractRunnable {

    public Producer(Queue<Long> queue, AtomicLong atomicLong, int delay, String threadName) {
        super(queue, atomicLong, delay, threadName);
    }

    @Override
    public void run() {

        while (true) {
            synchronized (AbstractRunnable.objectForSynchronize) {
                if (super.queue.size() < MainClass.MAX_CAPACITY) {
                    Long currentLong = atomicLong.incrementAndGet();

                    queue.add(currentLong);
                    System.out.printf(
                            "add key: %d. Thread name: %s" + System.lineSeparator(),
                            currentLong,
                            threadName
                    );
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } //else
                    // if full
                    try {
                        AbstractRunnable.objectForSynchronize.notifyAll();
                        AbstractRunnable.objectForSynchronize.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    @Override
    public String toString() {
        return "Producer{" +
                "threadName='" + threadName + '\'' +
                '}';
    }
}
