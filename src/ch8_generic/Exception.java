package ch8_generic;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

class MyDate extends Date {}
public class Exception {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        ExceptionTester<ArithmeticException> et = new ExceptionTester<ArithmeticException>();
//        et.test(ArithmeticException.class);

        List<? extends Date> ld = new ArrayList<> ();
        Collection<? extends Object> lo;
        System.out.println(lo = ld);

        /*try {
            new ExceptionTester<ClassNotFoundException>().test(new ClassNotFoundException());

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }*/
    }
}

class ExceptionTester<T extends Throwable> {
    public void test(Class<T> type) throws T, IllegalAccessException, InstantiationException {
        System.out.println(1);
        throw type.newInstance();
    }
}