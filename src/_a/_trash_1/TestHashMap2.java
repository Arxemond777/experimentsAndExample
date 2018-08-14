package _a._trash_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestHashMap2 {
    private static Map<IA, Object> map = new HashMap<>();

    public static void main(String[] args) {
        A_1 a_1 = new A_1();
        A_2 a_2 = new A_2();
        B_1 b_1 = new B_1();

        System.out.println("a_1: " + a_1.hashCode() + " | a_2: " + a_2.hashCode() + " | b_1: " + b_1.hashCode());
        map.put(a_1, 1);
        map.put(a_2, 2);
        map.put(b_1, 3);

        System.out.println(map);

        System.out.println(map.get(a_1));
        System.out.println(map.get(a_2));
        System.out.println(map.get(b_1));
    }
}

interface IA {}

class B_1 implements IA {
    @Override
    public String toString() {
        return "B_1{" +
                "id=" + id +
                '}';
    }

    private Integer id = 2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B_1 B_1 = (B_1) o;
        return Objects.equals(id, B_1.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}

class A_1 implements IA {
    @Override
    public String toString() {
        return "A_1{" +
                "id=" + id +
                '}';
    }

    private Integer id = 1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A_1 a_1 = (A_1) o;
        return Objects.equals(id, a_1.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}

class A_2 implements IA  {
    private Integer id = 1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A_2 a_2 = (A_2) o;
        return Objects.equals(id, a_2.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "A_2{" +
                "id=" + id +
                '}';
    }
}