package Naovember_06th_17_BlockingConcurrenctMethod;

import ch10_works_with_text.A;

import java.util.*;

public class EqualsInCollectionAndSpliterator {
    public static void main(String[] args) {
        a a = new a();
        a a1 = a;
        b b = new b();

//        System.out.println(a == a1);
//        System.out.println(a1 instanceof a);
//        System.out.println(a == b);

        HashMap m = new HashMap();
//        m.put(null, 3);
//        m.put(null, 4);
        m.put(a, 1);
        m.put(b, 2);
        m.put(a, 3);
        m.put(a, 3);
        m.put(a, 4);
        m.put(a, 5);

        //System.out.println(m);

        List<String> l = new ArrayList<> (100);
        l.add("a");
        l.add("c");
        l.add("h");
        l.add("b");

        Spliterator<String> stringSpliterator = l.spliterator();
        Spliterator<String> newStringSpliterator = stringSpliterator.trySplit();

        newStringSpliterator.tryAdvance(EqualsInCollectionAndSpliterator::b);
        newStringSpliterator.tryAdvance(EqualsInCollectionAndSpliterator::b);

        /*System.out.println("_size_");
        System.out.println(stringSpliterator.estimateSize());
        System.out.println(newStringSpliterator.estimateSize());
        System.out.println("_size_");
//        System.out.println(stringSpliterator);

        System.out.println(l);*/

//        newStringSpliterator.
//        System.out.println("123");
//        System.out.println(System.identityHashCode(new Object()));
//        System.out.println(System.identityHashCode(a));
//        System.out.println(System.identityHashCode(new b()));

        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");

        Iterator<String> listIterator = stringList.iterator();
//        stringList.add("2");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

    }

    private static void b(String s) {
        System.out.println("_____");
        System.out.println(Thread.currentThread().getName());
        System.out.println(s);
        System.out.println("_____");
    }

}

class a {
    @Override
    public boolean  equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {

        return (new Random().nextInt() * 3);
//        return 1;
    }
}

class b {
    @Override
    public boolean  equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {

        return 1;
    }
}