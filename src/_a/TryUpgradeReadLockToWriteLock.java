package _a;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TryUpgradeReadLockToWriteLock {
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        readWriteLock.readLock().lock();
        try {
            // always is false
            boolean b = readWriteLock.writeLock().tryLock();
            System.out.println(b);
//            readWriteLock.writeLock().lockInterruptibly();
        } catch (Throwable t) {
            System.out.println(t);
        } finally {
            readWriteLock.readLock().lock();
        }

    }
}
