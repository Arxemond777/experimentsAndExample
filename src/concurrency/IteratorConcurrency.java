package concurrency;

import java.util.Optional;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

public class IteratorConcurrency<T> {
    private Lock lock = new ReentrantLock();
    private final Stack<? extends T> stack;

    public IteratorConcurrency(Stack<? extends T> stack) {
        this.stack = stack;
    }

    Predicate hasnNext() {
        return s -> stack.size() != 0;
    }

    Optional<? extends T> next() throws NullPointerException {
        try {
            if (lock.tryLock(120, TimeUnit.SECONDS)) {
                try {
                    return Optional.ofNullable(stack.pop());
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return Optional.empty();
    }
}
