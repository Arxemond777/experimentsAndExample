import java.util.Arrays;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        Object[] ob = new Object[]{22, 7};
        System.out.println(Arrays.hashCode(ob));
        System.out.println(ob.hashCode());
        System.out.println("_________________");

        A a = new A();

        System.out.println(Objects.equals(new A(), new A()));

        System.out.println("____________");
        System.out.println(Objects.hash(a, new B()));
        System.out.println(Objects.hash(new B(), a));
        System.out.println(Objects.hash(a));
        System.out.println(Objects.hash(new B()));

        System.out.println("____________");
        System.out.println(Objects.hashCode(new A())); // берет hashCode
        System.out.println(Objects.hashCode(null)); // берет hashCode
    }
}

class A {
    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return 22;
    }
}

class B {
    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return 7;
    }
}