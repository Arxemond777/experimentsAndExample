package debuggerLearn;

import java.util.function.*;

public class TestsDebugger {
    static void display(int value) {
        System.out.println(value + " = value");
    }
    public static int i = 3;

    public static void main(String[] args) {
        int j = 4;
        for (int i = 0; i <= 10; i++) {

            //System.out.println("i = " + i);
        }

        //System.out.println(TestsDebugger.i);
        TestsDebugger.i = 5;

        A(User::getAge);

        User.setAge(Integer.parseInt("1"));
        Function<Integer, Integer> func = x -> x * 2;
        A(func);

        B(() -> 1);
        B(User::getAge);

        System.out.println("++++++");
        System.out.println("Consumer");
        Consumer<Integer> consumer = x -> display(x - 1);
        consumer.accept(3);

    }

    public static void A(Function function) {
        int result = (int) function.apply(10);

        System.out.println("Function");
        System.out.println(result);
        System.out.println("_____________");
    }

    public static void B(Supplier supplier) {
        System.out.println("Supplier");
        System.out.println(supplier.get());
        System.out.println("_____________");
    }
}

class User {
    private static Integer age = 3;

    public static Integer getAge() {
        return age;
    }

    public static void setAge(Integer age) {
        age = age;
    }

    public static Object getAge(Object o) {
        return age;
    }
}