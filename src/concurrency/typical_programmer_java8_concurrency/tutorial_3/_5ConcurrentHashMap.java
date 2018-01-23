package concurrency.typical_programmer_java8_concurrency.tutorial_3;

import jdk.nashorn.internal.objects.NativeArray;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap - use the common ForkJoinPool.commonPool() as well as parallel stream.
 * This Pool, иby default, use all the cores of the executable machine.
 * can change the VM option -Djava.util.concurrent.ForkJoinPool.common.parallelism=5
 */
public class _5ConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

//        forEach(map);
//        search(map);
//        searchByCondition(map);
        reduce(map);
    }

    private static void reduce(ConcurrentHashMap<String, String> map) {
        System.out.println(map);
        String result = map.reduce(1,
                (key, value) -> {
                    System.out.println("Transform: " + Thread.currentThread().getName());
                    return key + "=" + value;
                },
                (s1, s2) -> {
                    System.out.println("Reduce: " + Thread.currentThread().getName());
                    return s1 + ", " + s2;
                });

        System.out.println("Result: " + result);
    }

    private static void searchByCondition(ConcurrentHashMap<String, String> map) {
        String result = map.searchValues(1, value -> {
            System.out.println(Thread.currentThread().getName());
            if (value.length() > 3) {
                return value;
            }
            return null;
        });

        System.out.println("Result: " + result);
    }

    private static void search(ConcurrentHashMap<String, String> map) {
        String result = map.search(1, (key, value) -> {
            System.out.println(Thread.currentThread().getName());
            if ("foo".equals(key)) {
                return value;
            }
            return null;
        });
        System.out.println("Result: " + result);
    }

    private static void forEach(ConcurrentHashMap<String, String> map) {
        map.forEach(1, (key, value) ->
                System.out.printf("key: %s; value: %s; thread: %s\n",
                        key, value, Thread.currentThread().getName()));
    }
}
