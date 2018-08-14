package _a._trash_1;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public String name;

    public int hashCode() {
        return name.hashCode();
//        return 4;
    }

    public boolean equals(Object o) {
        if (o instanceof TestHashMap) {
            return name.equals(((TestHashMap) o).name);
        }
        return false;
    }

    public static void main(String[] args) {
        Map<TestHashMap, Integer> map = new HashMap<>();
        TestHashMap a1 = new TestHashMap();

        //TODO step 1: a cell in a Map calculates by hash-function of hashCode
        a1.name = "one"; // target index of a cell in a Map`s table calculates by hash-function of hashCode

        map.put(a1, 1); // applies a hash-function by hashCode (name.hashCode();)

        System.out.println(map);
        a1.name = "two"; // override, hashCode but not the objects itself. But REindex doesn`t perform
        System.out.println(map);

        TestHashMap a2 = new TestHashMap();
        a2.name = "one"; // instance a new object
//        map.put(a2, 2); // like linked list

        //TODO step 2: keys in a Map compare by equals
        System.out.println(map.get(a1)); // null, because we override it
        System.out.println(map.get(a2)); // null, because it ANOTHER instance of object

        System.out.println(map);
    }

    @Override
    public String toString() {
        return "TestHashMap{" +
                "name='" + name + '\'' +
                '}';
    }
}
