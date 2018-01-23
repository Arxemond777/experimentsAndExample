package a;

import sun.reflect.Reflection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = Arrays.asList("Ram","Shyam","Shiv","Mahesh");
        System.out.println(list.stream().collect(Collectors.joining("-","[","]")));
        System.out.println(list.stream().collect(Collectors.joining(";")));

        System.out.println((Runtime.getRuntime().maxMemory() / 1024 / 1024 ) + " mb");
//        System.exit(1);
        System.out.println("Привет");
        B b = new B();

        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }).run();
        Integer i = 1 + 2;
        Thread.sleep(1000);
        System.out.println(b.someClass().getName());
        System.out.println(b.someClass().getName());
        System.out.println(i);
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
