package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockWithTimeout {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(
                () -> {
                    lock.lock();
                    try {
                        System.out.println("lock acquired 1");
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
        ).start();

        new Thread(
                () -> {
                    boolean b;
                    try {
//                        b = lock.tryLock(100L * 21L, TimeUnit.MILLISECONDS); // true
                        b = lock.tryLock(100L, TimeUnit.MILLISECONDS); // false
                        System.out.println("try lock: " + b);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if (lock.isHeldByCurrentThread())
//                        if (b)
                            lock.unlock();
                    }
                }
        ).start();
    }
}
