package _a._trash_0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ListHashCodeTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();

        System.out.println(list1.hashCode());

        list1 = new LinkedList<>();

        System.out.println(list1.hashCode());

        list1.add(2);
        list1.add(3);

        System.out.println(list1.hashCode());

        list1.add(12);
        list1.add(12);
        list1.add(12);
        list1.add(12);
        list1.add(12);
        list1.add(12);
        list1.add(12);
        list1.add(12);
        list1.add(12);
        list1.add(12);
        list1.add(12);
        list1.add(12);
        list1.add(12);
        list1.add(12);
        list1.add(12);
        list1.add(12);
        System.out.println(list1.hashCode());

        new HashMap().hashCode();
        new HashMap().equals(new HashMap());
    }
}
