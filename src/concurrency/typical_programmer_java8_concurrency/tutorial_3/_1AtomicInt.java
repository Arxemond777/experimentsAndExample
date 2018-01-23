package concurrency.typical_programmer_java8_concurrency.tutorial_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static concurrency.typical_programmer_java8_concurrency.tutorial_2._1Synchronization.stop;

/**
 * see also: AtomicBoolean, AtomicLong и AtomicReference
 */
public class _1AtomicInt {
    public static void main(String[] args) {
//        simpleAtomicIntExample();
//        simpleAtomicIntUpdateExample();
        simpleAtomicIntAccumulateExample();
    }

    private static void simpleAtomicIntExample() {
        AtomicInteger atomicInt = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1000)
                .forEach(i -> executor.submit(atomicInt::incrementAndGet));

        stop(executor);

        System.out.println(atomicInt.get());
    }

    private static void simpleAtomicIntUpdateExample() {
        AtomicInteger atomicInt = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1000)
                .forEach(i -> {
                    Runnable task = () ->
                            atomicInt.updateAndGet(n -> n + 2);
                    executor.submit(task);
                });

        stop(executor);

        System.out.println(atomicInt.get());
    }

    private static void simpleAtomicIntAccumulateExample() {
        AtomicInteger atomicInt = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1000)
                .forEach(i -> {
                    Runnable task = () ->
                            atomicInt.accumulateAndGet(i, (n, m) -> n + m);
                    executor.submit(task);
                });

        stop(executor);

        System.out.println(atomicInt.get());    // => 499500
    }
}
