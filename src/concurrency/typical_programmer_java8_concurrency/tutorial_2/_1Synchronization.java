package concurrency.typical_programmer_java8_concurrency.tutorial_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class _1Synchronization {
    private static int count;
    private static final Object object = new Object();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000)
//                .forEach(i -> executor.submit(_1Synchronization::increment));
                .forEach(i -> executor.submit(_1Synchronization::incrementSyncMethodSynchronized));
//                .forEach(i -> executor.submit(_1Synchronization::incrementSyncBlockSynchronized));

//        executor.shutdown(); // TODO !without that you get value before executor end
        stop(executor); // TODO MORE SOFT !without that you get value before executor end
        System.out.println(count);
    }

    private static void increment() {
        count = count + 1;
    }

    private static synchronized void incrementSyncMethodSynchronized() {
        count = count + 1;
    }

    private static void incrementSyncBlockSynchronized() {
        synchronized (object) {
            count = count + 1;
        }
    }

    /**
     * executor have time and stop more soft, then with executor.shutdown()
     * @param executor
     */
    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
