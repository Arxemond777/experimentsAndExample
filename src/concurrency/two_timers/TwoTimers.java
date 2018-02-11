package concurrency.two_timers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MyThread extends Thread {

    private volatile long delay;
    private final String name;

    public MyThread(long delay, String name) {
        this.delay = delay;
        this.name = name;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    @Override
    public void run() {

        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(delay);


                System.out.printf("Thread name: %s; Thread delay: %d\n", this.name, this.delay);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " has been killed");
        }
    }
}

public class TwoTimers {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    volatile long timeForT1= 1500L;

    void doSomething() {
        MyThread
                t1 = new MyThread(timeForT1, "t1"),
                t2 = new MyThread(1000, "t2");

        executorService.submit(t1);
        executorService.submit(t2);

        try {
            Thread.sleep(2000);
            t1.setDelay(300L);
            executorService.shutdown();
            Thread.sleep(1000);
            executorService.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!executorService.isTerminated()) {
                System.out.println("Not finished tasks have been killed");
            }
            executorService.shutdownNow();
            System.out.println("Executors has been stopted");
        }
    }

    public static void main(String[] args) {
        new TwoTimers().doSomething();
    }
}
