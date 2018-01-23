package java_8.method_reference;

import java.util.function.Consumer;

public class Example1_1 {
    public static void main(String[] args) {
        a(A1::new);
    }

    static void a(Consumer<A1> consumer) {
        //consumer.accept(new BigDecimal(1));

        Consumer<A1> integerConsumerMultiply = e ->  e.setAge(2);
        consumer.andThen(integerConsumerMultiply).accept(new A1(1));
    }
}

class A1 {

    public A1(Object o) {
        System.out.println(o.getClass());
    }

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}