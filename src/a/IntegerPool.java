package a;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class IntegerPool {
    public static void main(String[] args) {
        //collection.stream().filter("13"::equals).findFirst().get()
        //new ArrayList<>().stream().filter()

        // Так поместится в пул строк каждый объект отдельно
        //http://javateaching.blogspot.ru/2011/12/integer-pool.html
        //http://info.javarush.ru/translation/2014/02/07/Java-String-%D0%92%D0%BE%D0%BF%D1%80%D0%BE%D1%81%D1%8B-%D0%BA-%D1%81%D0%BE%D0%B1%D0%B5%D1%81%D0%B5%D0%B4%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8E-%D0%B8-%D0%BE%D1%82%D0%B2%D0%B5%D1%82%D1%8B-%D0%BD%D0%B0-%D0%BD%D0%B8%D1%85-%D1%87-2.html
        Integer i0 = new Integer(1);
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);

        // Так будет закешированное значение
        Integer i3 = 1;
        Integer i4 = 1;
        Integer i5 = 1;

        // Так поместится каждый объект в пул отдельно, аналогично i0/**/
        Integer i6 = 130;
        Integer i7 = 130;
        Integer i8 = 130;

        System.out.println();
    }
}
