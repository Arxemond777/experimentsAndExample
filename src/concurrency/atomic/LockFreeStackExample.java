package concurrency.atomic;

import com.sun.org.apache.bcel.internal.generic.PUSH;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static concurrency.atomic.TypeOperation.PUSH;

public class LockFreeStackExample {
    public static void main(String[] args) throws InterruptedException {
        LockFreeStack<Integer> integerLockFreeStack = new LockFreeStack<>();

        ExecutorService executors = Executors.newWorkStealingPool();
        List<Callable<Object>> callables = new ArrayList<>();
        List<Future<Object>> futures = null;

        IntStream
                .range(0, Runtime.getRuntime().availableProcessors())
                .forEach(index ->
                        callables.add(new SimpleThread(integerLockFreeStack, PUSH))
                );

        if (CollectionUtils.isNotEmpty(callables)) {
            futures = executors.invokeAll(callables);
        }

//        executors.shutdown();
//        try {
//            executors.awaitTermination(5, TimeUnit.SECONDS);
//        } catch (InterruptedException ie) {
            System.out.println(futures);
            System.out.println(integerLockFreeStack.getStack());
//        } finally {
//            executors.shutdownNow();
//        }
    }
}