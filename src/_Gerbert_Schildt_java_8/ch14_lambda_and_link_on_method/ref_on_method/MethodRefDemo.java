package _Gerbert_Schildt_java_8.ch14_lambda_and_link_on_method.ref_on_method;

@FunctionalInterface
interface IntPredicate
{
    boolean test(int n);
}

class MyIntPredicates
{
    static boolean isPrime(int n) { // Predicate if number is simple
        if (n < 2)
            return false;

        for (int i = 2; i <= n / i; i++)
            if ((n % i) == 0)
                return false;

        return true;
    }

    static boolean isEven(int n) { // If number is Even
        return (n % 2) == 0;
    }

    static boolean isPositive(int n) { // If number more zero
        return n > 0;
    }
}

public class MethodRefDemo
{

    static boolean numTest(IntPredicate p, int v) {
        return p.test(v);
    }

    public static void main(String[] args) {
        boolean result;

        result = numTest(MyIntPredicates::isPrime, 17);
        if (result)
            System.out.println(result);

        result = numTest(MyIntPredicates::isEven, 12);
        if (result)
            System.out.println(result);

        result = numTest(MyIntPredicates::isPositive, 11);
        if (result)
            System.out.println(result);
    }

}
