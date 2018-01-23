package concurrency.typical_programmer_java8_concurrency.tutorial_2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static concurrency.typical_programmer_java8_concurrency.tutorial_2._1Synchronization.sleep;

public class _3ReadWriteLock {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Map<String, String> map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        executor.submit(() -> {
            lock.readLock().lock();
            try {
//                sleep(1);
                map.put("wtf!", "bar"); //TODO semantic was broken
                System.out.println(map);
            } finally {
                lock.readLock().unlock();
            }
        });
        executor.submit(() -> {
            lock.writeLock().lock();
            try {
                sleep(3);
                map.put("foo", "bar");
                System.out.println(map);
            } finally {
                lock.writeLock().unlock();
            }
        });

        executor.submit(() -> {
            lock.readLock().lock();
            try {
                System.out.println(map);
            } finally {
                lock.readLock().unlock();
            }
        });
    }
}
