package a;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.ref.PhantomReference;

public class _A {
    static {
        //System.out.println(2);
//        System.exit(0);
    }

    public static void main(String[] args) {
        System.exit(0);
        Map<Object, Integer> map = new ConcurrentHashMap<>();
        WeakHashMap weakHashMap = new WeakHashMap();

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (Integer i = 0; i < 2147483647 - 1; i++) {

            Integer finalI = i;
            executorService.submit(() -> {
                map.put(new Object(), finalI);
            });

            if (i % 1000000 == 0)
                System.out.println(i + " = " + map.size());
        }

        //System.out.println(map);
        System.out.println(map.size());
        System.out.println(2147483647 - 1);

        System.out.println("xet");
        System.exit(0);
        Long l1 = 10L;
        Long l2 = 0L;
        System.out.println(1L > 0L);
        System.out.println(l1.longValue() <= l2.longValue());
        System.out.println(l1 == l2);
    }
}