package Naovember_06th_17_BlockingConcurrenctMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentMethodV1 {

    static final Object o = new Object();
/*1*/ //   static public List<Long> arrLong = Collections.synchronizedList( // TODO Так
//            new ArrayList<>()
//    )
//    ;

    /*2*/       static public List<Long> arrLong = new ArrayList<>();

/*3*///    static public List<Long> arrLong = new CopyOnWriteArrayList<>(); // TODO для частых чтений и редких вставок

    public static void main(String[] args) throws InterruptedException {
        Integer coreNum = Runtime.getRuntime().availableProcessors();

        ExecutorService executorService = Executors.newFixedThreadPool(coreNum);

        Long arrSize = 1_000_000L;

        for (long l = 1L; l <= arrSize; ++l) {
            long finalL = l;
            executorService.submit(() -> {
                synchronized (o) { // TODO ТАК
                    arrLong.add(finalL);
                }
            });

            if (l == arrSize) {
                Thread.sleep(500); // Чтоб успеол досчитать
                long finalL1 = l;
                new Thread(() -> {
                    System.out.printf("Size %d. Elem %d", arrLong.size(), finalL1);
                }).start();
            }
        }


    }
}

