package concurrency.typical_programmer_java8_concurrency.tutorial_3;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class _4ConcurrentMap {
    public static void main(String[] args) {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

//        forEach(map);
//        putIfAbsent(map);
//        getOrDefault(map);
//        replaceAll(map);
        compute(map); // only one value will be change unlike replaceAll
    }

    private static void compute(ConcurrentMap<String, String> map) {
        map.compute("foo", (key, value) -> value + value);
        System.out.println(map.get("foo"));   // barbar
    }

    private static void replaceAll(ConcurrentMap<String, String> map) {
        map.replaceAll((key, value) -> "r2".equals(key) ? "d3" : value);
        System.out.println(map.get("r2"));    // d3
    }

    private static void getOrDefault(ConcurrentMap<String, String> map) {
        String value = map.getOrDefault("hi", "there");
        System.out.println(value);    // there
    }

    private static void putIfAbsent(ConcurrentMap<String, String> map) {
        String value = map.putIfAbsent("c3", "p1");
        System.out.println(value);
    }

    private static void forEach(ConcurrentMap<String, String> map) {
        map.forEach((key, value) -> System.out.printf("%s = %s\n", key, value));
    }
}
