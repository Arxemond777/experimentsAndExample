package concurrency.typical_programmer_java8_concurrency.tutorial_1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _7ScheduleAtFixedRate_VS_scheduleWithFixedDelay {
    private static final int period = 1;
    public static void main(String[] args) {
//        scheduleAtFixedRate();
        scheduleWithFixedDelay();
    }

    /**
     * scheduleAtFixedRate - exclude the time execution of task. if time execution time more then
     * {@link _7ScheduleAtFixedRate_VS_scheduleWithFixedDelay#period} then tasks will be
     * accumulation in the executor's queue
     */
    private static void scheduleAtFixedRate() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());

        int initialDelay = 0;

        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    }

    /**
     * scheduleWithFixedDelay - start next task after
     * endPreviousTask+{@link _7ScheduleAtFixedRate_VS_scheduleWithFixedDelay#period}
     */
    private static void scheduleWithFixedDelay() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
    }
}
