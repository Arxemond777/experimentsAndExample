package test;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by urijglusenkov on 03.12.16.
 */
public class data_03_12_16 {

    public static void main(String [] args) {

        data_03_12_16 d = new data_03_12_16();
        //d.labuda();
        Object a = new Object();
        //d.xer(1, 2, a);
        d.xz();
    }

    void labuda() {
        List Numbers = new ArrayList();
        Integer t = new Integer(33);
        Numbers.add(t);

        System.out.println(Numbers);

        Integer xer = (Integer)Numbers.get(0);

        System.out.println(xer);

    }

    void xer (Object ... list) {

        for (Object o : list) {
            System.out.println(o);
        }
    }

    void xz() {
        System.out.println(1);
        synchronized (this) {
            int a = 1;
            System.out.println(2);
        }
        {
            System.out.println(3);
        }
        System.out.println(4);
        System.out.println(data_03_12_16.class);
    }
}
