package java_8.method_reference;

import java.util.function.Function;
import java.util.function.Supplier;

public class Example2 {

    public static void main(String[] args) {
        Supplier<Foo> foo = bind(Foo::new, "example1");
        Foo foo1 = foo.get();

        //////
        MyFoo myFoo = Foo::new;
        Foo foo2 = myFoo.func("example2");
    }

    public static <T, R> Supplier<R> bind(Function<T,R> fn, T val) {
        return () -> fn.apply(val);
    }
}

interface MyFoo {
    Foo func(String s);
}

class Foo {
    Foo (Object s) {

    }

    Foo (String s) {
        System.out.println(s);
    }
}
