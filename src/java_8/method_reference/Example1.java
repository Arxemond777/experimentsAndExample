package java_8.method_reference;

import java.math.BigDecimal;
import java.util.function.*;

public class Example1 {
    public static void main(String[] args) {
        a(A::new);
    }

    static void a(Consumer<BigDecimal> consumer) {
        consumer.accept(new BigDecimal(1));
    }
}

class A {

    public A(Object o) {
        System.out.println((BigDecimal)o);
    }
}