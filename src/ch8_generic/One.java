package ch8_generic;

import java.util.*;

public class One {
    public static void main(String[] args) {
        List<String> listOfString;
        Map<Integer, String> employees = new HashMap<>();
//        employees.put(1, "Xer");
//        employees.put(2, "Xer2");
//        employees.put(2, "Xer3");
//        employees.put(3, "Xer3");
//        System.out.println(employees);
//        for (Map.Entry<Integer, String> val: employees.entrySet()) {
//            System.out.print(val.getValue().toString() + "\n");
//        }

        One o = new One();
        o.a(new Date());

        Object ob = new ArrayList<String>();
        List<Date> ld = (List<Date>)ob;
        Date d = ld.get(0);
//        char[] chars = new char[]{'a','n'};
//        System.out.println(chars);
    }

    void b() {
    }

    public <T> T a(T type) {
        System.out.println(type);
        return type;
//        T r = new T();
//        return r;
    }
}

class M<K, V> {
    public K get(K a) {
        return a;
    }
}