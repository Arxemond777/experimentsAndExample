package _a;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest
{
    private static volatile int i = 0;
    public static void main(String[] args) {
        final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(15);

        /*queue.add(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(++ThreadPoolTest.i + " " + new Date().toString());
        });*/

        //RejectedExecutionException - Летит при привышения лимита
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 3, 0L, TimeUnit.NANOSECONDS, queue);

        for (int j = 0; j < 20; j++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(++ThreadPoolTest.i + " " + new Date().toString());
            });
        }

        executorService.shutdown();
    }
}
