package concurrency.typical_programmer_java8_concurrency.tutorial_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class _2ReentrantLock {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ReentrantLock lock = new ReentrantLock();

        executor.submit(() -> { // pool-1-thread-1
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " held by me: " + lock.isHeldByCurrentThread());
                _1Synchronization.sleep(1);
            } finally {
                lock.unlock();
            }
        });

        executor.submit(() -> { // pool-1-thread-2
            System.out.println("Locked: " + lock.isLocked());
            System.out.println(Thread.currentThread().getName() + " held by me: " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired: " + locked);
        });

        _1Synchronization.stop(executor);
    }
}
