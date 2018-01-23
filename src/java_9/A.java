package java_9;

import sun.reflect.Reflection;

import sun.reflect.Reflection;

import java.util.Arrays;

public class A {
    public static void main(String[] args) {
        System.out.println((Runtime.getRuntime().maxMemory() / 1024 / 1024 ) + " mb");
        System.exit(1);
        System.out.println("Привет");
        B b = new B();

        System.out.println(b.someClass().getName());
    }
}

class B {
    Class<?> someClass() {
        System.out.println(2);
        System.out.println(Reflection.getCallerClass(2));
        System.out.println(2);
        return new C().someClass();
    }
}

class C {
    Class<?> someClass() {
        System.out.println(1);
        //System.out.println(Reflection.getCallerClass(4));
        //System.out.println(Reflection.getCallerClass(3));
        //System.out.println(Reflection.getCallerClass(2));
        System.out.println(Reflection.getCallerClass(1));
//        System.out.println(Reflection.getCallerClass(0));

        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
        System.out.println(1);
        return Reflection.getCallerClass(2);
    }
}

