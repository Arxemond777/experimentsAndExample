package ch8_generic;

import java.util.*;

public class Two {
    public static void main(String[] args) {
        Trap<Mouse> mouseTrap = new Trap<>();
        mouseTrap.snare(new Mouse());
        Mouse mouse = mouseTrap.release();

//        Mouse ms = new Mouse();
//        System.out.println(Mouse.b());
//        mouseTrap.test(Mouse.b());
    }
}
class A<T> {

}

class Mouse {
    public void a() throws Throwable {
//        List<?> ln = new ArrayList<>();
    }

    public static Object b() {return new Object();}

    void useList(List<String>... useList) {
        List<String> l1 = useList[0];
        ArrayList<?>[] arr = new ArrayList[10];
    }

    static <T extends A<? super T>> void b (List<T> list) {
        System.out.println(list);
    }
}

class Bear {
}

class Trap<T> {
    T trapped;
    public void snare(T trapped) {
        this.trapped = trapped;
    }

    public T release() {
        return  trapped;
    }

    public Class<T> test(Class<T> type) {
        return type;
    }
}