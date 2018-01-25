package Naovember_06th_17_BlockingConcurrenctMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PlayingWithSupplier {
    public static void main(String[] args) {
//        System.out.println(Runtime.runFinalizersOnExit(););
//        StringBuffer
        PlayingWithSupplier playingWithConsumer = new PlayingWithSupplier();

        Iterator<People> peopelIterator = playingWithConsumer.list.iterator();

        while (peopelIterator.hasNext()) {
            playingWithConsumer.consumer(peopelIterator::next);
        }

        List<Integer> l = Stream.iterate(0, x -> x+1).limit(10).peek(System.out::println).collect(Collectors.toList());

        List<People> list = IntStream.rangeClosed(1, 4)
                .boxed()
                .flatMap(value ->
                        IntStream.rangeClosed(1, 13)
                                .mapToObj(suit -> new PlayingWithSupplier().new People())
                )
                .collect(Collectors.toList());

    }


    /*private List<People> list = Stream.iterate(0, x -> x+1).limit(10).flatMap(value ->
            IntStream.rangeClosed(1, 13)
                    .mapToObj(suit -> new PlayingWithSupplier().new People())
    ).collect(Collectors.toList());*/

    private List<People> list = Arrays.asList(new People(), new People(), new People());

    class People {
        void sayHellow() {
            System.out.println(LocalDateTime.now());
        }
    }

    void consumer(Supplier<People> consumer) {
        consumer.get().sayHellow();
    }
}
