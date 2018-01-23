package shenandoah_first_acquaintance;

import java.util.Date;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Shenandoah {
    public static void main(String[] args) {
//        final int availableCore = Runtime.getRuntime().availableProcessors();
        final int availableCore = 2;

        final ExecutorService executorService
                = Executors.newFixedThreadPool(availableCore);
// -XX:+UseShenandoahGC -Xms20G -Xmx50G
        while (true)
            IntStream.range(0, availableCore).forEach(t -> {
                Callable<Date> callableTask = () -> {
                    /*try {
                        TimeUnit.MICROSECONDS.sleep(0);
                    } catch (InterruptedException ie) {
                    }*/

                    Date date = new Date();
                        /*for (int i = 0 ; i < 100; i++) {
                            if (!date.equals(new Date()))
                                date = new Date();
                        }*/
                    Date date1 = new Date();

                    if (date.equals(date1))
                        return new Date();
                    else
                        return new Date();
                };

                Future<Date> future = executorService.submit(callableTask);

                try {
//                    System.out.println(
                            future.get()
//                    )
                        ;
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
    }
}
