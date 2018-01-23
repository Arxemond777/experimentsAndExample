package a;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//TODO https://habrahabr.ru/post/337350/
public class CollectionsHabraPost {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(4);
        integerList.add(3);
        integerList.add(2);
        integerList.add(1);
        integerList.add(5);
        integerList.add(8);

//        integersSynchronized();

//        toArray(integerList);

//        maxAndMin(integerList);

//        countCollections(integerList);

//        rightFilter(integerList);

//        anyMatchVsAllMatch(integerList);

//        generateStream();

        countingCollection(integerList);
    }

    static void integersSynchronized() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(4);
        integerList.add(3);
        integerList.add(2);
        integerList.add(1);
        integerList.add(5);
        /**
         * и на синхронизированных коллекциях Collections.synchronizedList VS .stream().forEach
         */

        integerList.forEach(System.out::println);
        System.out.println("_________");
        integerList.stream().forEach(System.out::println);
        List<Integer> integersSynchronized = Collections.synchronizedList(integerList);
        System.out.println("_________");
        integersSynchronized.forEach(System.out::println);
        System.out.println("_________");
        integersSynchronized.stream().forEach(System.out::println);
    }

    static void toArray(List<Integer> integerList) {

        //TODO аналогичны через стрим и Collections.toArray()
        System.out.println("_________");
        Integer[] i = integerList.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(i));
        Integer[] i1 = integerList.toArray(new Integer[0]);
        System.out.println(Arrays.toString(i1));
    }

    static void maxAndMin(List<Integer> integerList) {
        integerList.stream().max((p1, p2) -> Integer.compare(p1, p2)).orElse(null);
        Integer i1 = integerList.stream().max(Integer::compare).orElse(0);
        System.out.println(i1);
//        integerList.stream().max()
        Integer i = Collections.max(integerList);
        System.out.println(i);
    }

    static void countCollections(List<Integer> integerList) {
        System.out.println(integerList.stream().count()); // В java 8 пересчитывает всю коллекцию, в java9 быстрее size()
        System.out.println((long) integerList.size());
    }

    static void rightFilter(List<Integer> integerList) {
        System.out.println(integerList.stream().filter(integer -> !integer.equals(1)).findFirst().isPresent());
        System.out.println(integerList.stream().filter(integer -> !integer.equals(4)).findFirst());

        System.out.println(integerList.stream().anyMatch(integer -> !integer.equals(4)));
    }

    static void anyMatchVsAllMatch(List<Integer> integerList) {
        //System.out.println(integerList.stream().anyMatch(i -> !integerList.equals(1)));
        System.out.println(!integerList.stream().anyMatch(i -> !i.equals(1)));
        System.out.println("_____________");
        List<Integer> i11111 = Arrays.asList(1, 2);
        System.out.println(i11111);
        System.out.println(i11111.stream().allMatch(i -> i.equals(1)));
        //System.out.println(!integerList.stream().allMatch(i -> integerList.equals(1)));
    }

    static void generateStream() {
        class MyObject {
            LocalDate localDate;

            MyObject() {
                this.localDate = LocalDate.now();
            }

            public LocalDate getLocalDate() {
                return this.localDate;
            }
        }

        Stream.generate(() -> new MyObject()).limit(3);
        Stream.generate(MyObject::new).limit(3).forEach((MyObject::getLocalDate));
    }

    static void rangeCollection() {
//        IntStream.range(0, Math.min(array.length, 2)).mapToObj(idx -> array[idx]);
    }

    static void countingCollection(List<Integer> integerList) {
//        integerList.stream().mapToLong(List::size).sum();
        //TODO if(stream.filter(condition).count() > 0) перебирает все, в отличие от anyMatch(condition)

        //TODO f(stream.count() > 2) хитрее stream.limit(3).count()

        //TODO  stream.sorted(comparator).findFirst() все равно что stream.min(comparator)
    }
}
