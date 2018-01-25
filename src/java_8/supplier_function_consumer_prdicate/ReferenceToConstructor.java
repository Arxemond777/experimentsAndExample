package java_8.supplier_function_consumer_prdicate;

import java.util.*;
import java.util.function.Function;

public class ReferenceToConstructor {

    public static void main(String[] args) {
        // TODO code application logic here
        List numbers = Arrays.asList(4, 9, 16, 25, 36);
        List squaredNumbers = ReferenceToConstructor.findSquareRoot(numbers, x -> x * 2);
        System.out.println("Square root of numbers = " + squaredNumbers);

        squaredNumbers = ReferenceToConstructor.findSquareRoot(numbers, Integer::new);
        System.out.println("Square root of numbers = " + squaredNumbers);
    }

    private static List findSquareRoot(List list, Function<Integer, Integer> f) {
        System.out.println(f.apply(1));
        List result = new ArrayList();
        list.forEach(x -> result.add(f.apply((Integer) x)));
        return result;
    }
}
