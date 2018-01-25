package Naovember_06th_17_BlockingConcurrenctMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentMethodV2 {

    static final Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        SomeClass someClass = new SomeClass(new ArrayList<>());

        Integer coreNum = Runtime.getRuntime().availableProcessors();

        ExecutorService executorService = Executors.newFixedThreadPool(coreNum);

        Long arrSize = 1_000_000L;

        for (long l = 1L; l <= arrSize; ++l) {
            long finalL = l;
            executorService.submit(() -> {
                synchronized (o) { // work for inner method
                    someClass.addToList(finalL);
                }
            });

            if (l == arrSize) {
                Thread.sleep(500); // Чтоб успеол досчитать
                long finalL1 = l;
                new Thread(() -> {
                    System.out.printf("Size V2 %d. Elem %d", someClass.getSizeList(), finalL1);
                }).start();
            }
        }
    }
}

class SomeClass {
    private List<Long> list;

    SomeClass(List<Long> list) {
        this.list = list;
    }

    void addToList(Long l) {
        this.list.add(l);
    }

    int getSizeList() {
        return this.list.size();
    }

}