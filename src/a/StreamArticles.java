package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@FunctionalInterface
interface vasyInterface {
    Long getId();
}

class Vasy implements vasyInterface {
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

public class StreamArticles {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b");
        List<String> collections = list.stream().map(String::toUpperCase).peek((e) -> System.out.print("," + e)).
                collect(Collectors.toList());

        System.out.println(collections);

        Vasy vasy = new Vasy();
        vasy.setId(1L);
        Vasy vasy1 = new Vasy();
        vasy1.setId(2L);
        List<Vasy> listVasy = Arrays.asList(vasy, vasy1);
        List<Long> longList = listVasy.stream().map(Vasy::getId).collect(Collectors.toList());
        System.out.println(longList);

        /*List<Long> someCollections = null;
        Long someLong = null;
        long before = System.nanoTime();
        //for (int i = 0; i < 100000; i++) {
            someCollections = LongStream
//            someLong = LongStream
                    .range(1, 20000000)
                    //.peek((e) -> {})
                    .parallel()
                    .map(s -> s)
                    //.sequential()
//                    .reduce(0, (a, b) -> a + b);
                    .boxed()
                    //.sequential().parallel()
                    .collect(Collectors.toList());
        //}
        long after = System.nanoTime();

        System.out.println(someCollections);
        System.out.println(someLong);
        System.out.println((after-before)/ 1000000000.0);
        System.out.println("________");*/

        boolean b = Stream.of("a1", "a2", "a3", "a1").allMatch((s) -> s.contains("1"));
        System.out.println(b);

        /*peoples.stream()
                .sorted(
                        (o1, o2)
                                -> o1.getSex() != o2.getSex() ? o1.getSex().compareTo(o2.getSex())
                                : o1.getAge().compareTo(o2.getAge())
                ).collect(Collectors.toList());*/
    }

    static void a(Long l) {
        System.out.println(l);
    }
}
