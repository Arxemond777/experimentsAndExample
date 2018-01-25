package java_8.supplier_function_consumer_prdicate;

import java.util.function.*;
import java.util.*;

public class Program {

    static void display(Supplier<Integer> arg) {
        System.out.println("Supplier: " + arg.get());
    }

    static void display2(int value) {

        switch (value) {
            case 1:
                System.out.println("There is 1 value");
                return;
            default:
                System.out.println("There are " + Integer.toString(value)
                        + " values");
                return;
        }
    }

    public static void main(String[] args) {

        // Create a Function from a lambda expression.
        // ... It returns the argument multiplied by two.
        Function<Integer, Integer> func = x -> x * 2;

        // Apply the function to an argument of 10.
        int result = func.apply(10);
        System.out.println("Function: " + result);

        // Supplier
        display(() -> 1);

        // Predicate
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.removeIf(element -> element.startsWith("c"));
        System.out.println("Predicate: " + list.toString());

        // Consumer
        Consumer<Integer> consumer = x -> display2(x - 1);

        // Use the consumer with three numbers.
        consumer.accept(1);
        consumer.accept(2);
    }


}
