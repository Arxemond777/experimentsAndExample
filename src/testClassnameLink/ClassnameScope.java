package testClassnameLink;


import java.lang.Object;
class A {

    int a = 1, b;

    public A (/*int b*/) {
        b = b;
    }
}

public class ClassnameScope extends A {

    static final float fres = 1_2.0f;

    public static void main(String [] args) {

        Bazz bazz = new Bazz(new Foo());
        int result = bazz.foo1;

        System.out.println("foo = " + result);
        System.out.println(ClassnameScope.fres);

        ClassnameScope ClassnameScope = new ClassnameScope();
        System.out.println(ClassnameScope.b);
        //Xer xer = new Xer(Xer.x);


        //System.out.print(x.b);
    }

    /*public shortg () {
        System.out.println(super.a);
    }*/

    public enum x {a, b, c};


    class Xer {
        static final float x = 1_2.0f;
        protected float e = 1f;
        Xer (Xer c) {
            c = c;
        }

        /*Xer getC() {
            return c;
        }*/
    }

}

class Foo {

    int foo = 123;

}

class FooFalse {

    int foo = 666;

}

class Bazz {

    int foo1;

    Bazz(Foo foo) {
        FooFalse fooFalse = new FooFalse();

        foo.foo = fooFalse.foo;
        foo1 = foo.foo;

        int xyi = 0;
        if (xyi != 0) {
            foo.foo = ++foo.foo;
            foo.foo = ++foo.foo;

        }
        {
            foo.foo = ++foo.foo;
            foo.foo = ++foo.foo;
        }

        foo1 = foo.foo;


    }

}
