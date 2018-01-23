package concurrency.typical_programmer_java8_concurrency.tutorial_2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

import static concurrency.typical_programmer_java8_concurrency.tutorial_2._1Synchronization.sleep;
import static concurrency.typical_programmer_java8_concurrency.tutorial_2._1Synchronization.stop;

/**
 * reentrant - re-entrant (повторно входимый) you can call such a function from yourself
 * (or thought several levels of nesting) WITHOUT unpredictable consequences
 *
 * StampedLock don`t implement a REENTRANT
 * NOT reentrant == NOT thread safety (НЕреентрантный == потокоНЕбезопасный)
 * StampedLock - NOT reentrant
 */
public class _4StampedLock_newInJava8 {
    private static int count;

    public static void main(String[] args) {
//        analogueReadWriteLock();
//        optimisticReadLock();
        tryConvertToWriteLock();
    }

    private static void analogueReadWriteLock() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        StampedLock lock = new StampedLock();

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                sleep(1);
                map.put("foo", "bar");
                System.out.println(stamp);
            } finally {
                lock.unlockWrite(stamp);
            }
        });

        Runnable readTask = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println(map.get("foo"));
                System.out.println(stamp);
                sleep(1);
            } finally {
                lock.unlockRead(stamp);
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);

        stop(executor);
    }

    /**
     * optimisticReadLock - is a valid while first read-lock and either end task or write-lock
     */
    private static void optimisticReadLock() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        StampedLock lock = new StampedLock();

        executor.submit(() -> {
            long stamp = lock.tryOptimisticRead();
            try {
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                sleep(1);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                sleep(2);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
            } finally {
                lock.unlock(stamp);
            }
        });

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println("Write Lock acquired");
                sleep(2);
            } finally {
                lock.unlock(stamp);
                System.out.println("Write done");
            }
        });

        stop(executor);
    }

    /**
     * try convert read-lock in write-lock
     */
    private static void tryConvertToWriteLock() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        StampedLock lock = new StampedLock();

        executor.submit(() -> {
            long stamp = lock.readLock();
            try {
                if (count == 0) {
                    stamp = lock.tryConvertToWriteLock(stamp);
                    if (stamp == 0L) {
                        System.out.println("Could not convert to write lock");
                        stamp = lock.writeLock();
                    }
                    count = 23;
                }
                System.out.println(count);
            } finally {
                lock.unlock(stamp);
            }
        });

        stop(executor);
    }
}
