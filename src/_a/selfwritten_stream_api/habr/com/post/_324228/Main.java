package _a.selfwritten_stream_api.habr.com.post._324228;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dataset.of(Arrays.asList("foo", "bar")).forEach(System.out::println);

//        Dataset.of(Arrays.asList("шла", "саша", "по", "шоссе"))
//                .union(Arrays.asList("и", "сосала", "сушку"))
//                .filter(s -> s.length() > 4)
//                .map(s -> s + ", length=" + s.length())
//                .forEach(System.out::println);
    }
}
