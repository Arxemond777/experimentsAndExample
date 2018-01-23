package plays_with_multi_thread;

import java.util.Arrays;

public class a {
    private static UnaryFunction<Object> IF = new UnaryFunction<Object>() {
        public Object apply(Object args) {return args;};
    };

    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identityFunction() {
        return (UnaryFunction<T>) IF;
    }

    public static void main(String[] args) {
        String [] s = {"a", "b", "c"};
        UnaryFunction<String> stringUnaryFunction = identityFunction();
        for (String sVal : s)
            System.out.println(stringUnaryFunction.apply(sVal));
    }
}

@FunctionalInterface
interface UnaryFunction<T> {
    T apply(T args);
}