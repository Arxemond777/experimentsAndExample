package java_8.method_reference;

public class ExampleMethodReferenceStatic {
    public static void main(String[] args) {
        SomeInt someInt = ExampleMethodReferenceStatic1::isPrime;
        someInt.isBool(3);
    }
}

@FunctionalInterface
interface SomeInt {
    boolean isBool(int n);
}

class ExampleMethodReferenceStatic1 {
    static boolean isPrime(int n) {
        return true;
    }
}