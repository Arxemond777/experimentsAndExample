package concurrency.typical_programmer_java8_concurrency.tutorial_1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class _5ExecutorsInvokeAnyTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool(); // cont core

        List<Callable<String>> callables = Arrays.asList(
                callable("task1", 2),
                callable("task2", 1),
                callable("task3", 3));

        String result = executor.invokeAny(callables);
        System.out.println(result);
    }

    private static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }
}
