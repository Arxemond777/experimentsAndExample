package amqp_my_test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test
{
    public static void main(String[] args) throws InterruptedException {
        int count = 2000;
        //int count = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(count);

        for (int i = 1; i <= count; i++)
            executor.submit(new Counter(Integer.toString(i)));

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
    }
}

class Counter implements Runnable
{
    private String name;
    private final Object object = new Object();

    public Counter(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (this.object) {
            for (int i = 0; i < 100; ++i) {
                //System.out.println(this.name + " : " + i);

                try {
                    TimeUnit.MICROSECONDS.sleep((0 + (int) (Math.random() * 100)));
                    //TimeUnit.SECONDS.sleep((0 + (int) (Math.random() * 1)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("___________");
            System.out.println("+++" + this.name + "+++");
            System.out.println("___________");
        }
    }
}
