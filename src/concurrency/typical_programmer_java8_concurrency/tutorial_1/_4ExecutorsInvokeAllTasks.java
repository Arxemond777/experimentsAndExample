package concurrency.typical_programmer_java8_concurrency.tutorial_1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _4ExecutorsInvokeAllTasks {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(1);
                    return "task1";
                    },
                () -> {
                    System.out.println(2);
                    return "task2";
                },
                () -> {
                    System.out.println(3);
                    return "task3";
                });

        executor.invokeAll(callables)
                /*.stream()
                .map(future -> {
                    try {
                        return future.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println)*/;
    }
}
