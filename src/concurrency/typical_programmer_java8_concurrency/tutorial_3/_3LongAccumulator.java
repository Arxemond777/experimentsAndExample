package concurrency.typical_programmer_java8_concurrency.tutorial_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

import static concurrency.typical_programmer_java8_concurrency.tutorial_2._1Synchronization.stop;

/**
 * store value in itself (in RAM) excluding unnecessary interactions between threads =>
 * faster then AtomicLong but requires more memory
 */
public class _3LongAccumulator {
    public static void main(String[] args) {
        LongBinaryOperator op = (x, y) -> 2 * x + y;
        LongAccumulator accumulator = new LongAccumulator(op, 1L);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 2)
                .forEach(i -> executor.submit(() -> accumulator.accumulate(i)));

        stop(executor);

        System.out.println(accumulator.getThenReset());
    }
}
