package concurrency.typical_programmer_java8_concurrency.tutorial_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

import static concurrency.typical_programmer_java8_concurrency.tutorial_2._1Synchronization.stop;

/**
 * store value in itself (in RAM) excluding unnecessary interactions between threads =>
 * faster then AtomicLong but requires more memory
 */
public class _2LongAdder {
    private final static LongAdder adder = new LongAdder();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1000)
                .forEach(i -> executor.submit(adder::increment));

        stop(executor);

        System.out.println(adder.sumThenReset());   // => 1000
    }
}
