package concurrency.atomic;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static concurrency.atomic.TypeOperation.PUSH;

public class SimpleThread implements Callable {
    private final LockFreeStack<Integer> stack;
    private final TypeOperation typeOperation;

    public SimpleThread(LockFreeStack<Integer> stack, TypeOperation typeOperation) {
        this.stack = stack;
        this.typeOperation = typeOperation;
    }

    @Override
    public Object call() throws Exception {
        if (Objects.equals(typeOperation, PUSH)) {
            IntStream
                    .range(0, new Random().nextInt(100))
                    .forEach(stack::push);
        } else {
            throw new UnsupportedOperationException();
        }

        return new Object();
    }
}
