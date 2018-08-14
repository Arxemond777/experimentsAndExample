package _a;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RecursiveSynchronize {
    static Object obj = new Object();
    static long justLong = 0L;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int count = 2;

        ExecutorService executorService = Executors.newFixedThreadPool(count);
        List<Callable<String>> collect = IntStream.range(0, count).mapToObj(e ->
                new MyCallable<String>()
        ).collect(Collectors.toList());
//
        List<Future<String>> futures = executorService.invokeAll(collect);
        executorService.shutdown();

    }

    static Callable<String> a() {
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " - " + ++justLong);
        }
        return () -> "1";
    }
}

class MyCallable<Void> implements Callable<Void> {

    @Override
    public Void call() {
        while (true)
            RecursiveSynchronize.a();
    }
}