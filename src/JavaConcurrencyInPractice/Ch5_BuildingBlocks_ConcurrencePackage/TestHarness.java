package JavaConcurrencyInPractice.Ch5_BuildingBlocks_ConcurrencePackage;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TestHarness {

    private final static int availableProcessors = Runtime.getRuntime().availableProcessors();
    
    public static void main(String[] args) throws InterruptedException {
        TestHarness testHarness = new TestHarness();

        long timeOfExecutions = testHarness.timeTasks(
                TestHarness.availableProcessors,
                () -> {
                    int delay = new Random().nextInt(TestHarness.availableProcessors);
                    System.out.println(
                            "ThreadName: " + Thread.currentThread().getName() +
                                    " | randomInt " + delay
                    );
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        System.out.println("timeOfExecutions = " + timeOfExecutions);
    }

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException ignored) { }
            });
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end-start;
    }
}