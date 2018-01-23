package concurrency.producer_consumer;

import concurrency.AbstractRunnable;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public class Consumer extends AbstractRunnable {

    public Consumer(Queue<Long> queue, AtomicLong atomicLong, int delay, String threadName) {
        super(queue, atomicLong, delay, threadName);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (AbstractRunnable.objectForSynchronize) {
                if (!queue.isEmpty()) {
                    Long l = queue.poll();

                    System.out.printf(
                            "poll key: %d. Thread name: %s" + System.lineSeparator(),
                            l,
                            threadName
                    );

                    AbstractRunnable.objectForSynchronize.notifyAll();

                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } //else
                    // if empty
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
        return "Consumer{" +
                "threadName='" + threadName + '\'' +
                '}';
    }
}
