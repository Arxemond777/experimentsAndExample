package concurrency.atomic;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class LockFreeStack<T> {
    public AtomicReference<Holder<T>> getStack() {
        return stack;
    }

    final private AtomicReference<Holder<T>> stack;

    LockFreeStack() {
        stack = new AtomicReference<>();
    }

    public void push(T item) {
        Holder<T> oldHead, newHead = new Holder<T>(item);

        do {
            oldHead = stack.get();
            newHead.next = oldHead;
        } while (!stack.compareAndSet(oldHead, newHead));
    }

    public T pop() {
        Holder<T> oldHead, newHead;

        do {
            oldHead = stack.get();

            if (Objects.isNull(oldHead)) return null;

            newHead = oldHead.next;

        } while (!stack.compareAndSet(oldHead, newHead));

        return oldHead.current;
    }

    private class Holder<T> {

        private T current;
        private Holder<T> next;

        private Holder(T current) {
            this.current = current;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Holder{" +
                    "current=" + current +
                    ", next=" + next + // Attention: can be StackOverflow
                    '}';
        }
    }
}
