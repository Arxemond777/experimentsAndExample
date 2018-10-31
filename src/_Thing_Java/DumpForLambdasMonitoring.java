package _Thing_Java;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

abstract class hh {}

class User extends hh implements c{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class DumpForLambdasMonitoring {
    static Integer v = 1;
    static final Integer v1;
    static {
        v = 2;
        v1 = 3;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(v);
        System.out.println(v1);

        User user = new User();
        user.setName("user");

        User user2 = user;
        user.setName("user2");

        System.out.println(user.getName());
        System.out.println(user2.getName());

        List<DumpForLambdasMonitoring1> l = new LinkedList<>();

        while (true) {

            DumpForLambdasMonitoring1<Long> longb
                    = new DumpForLambdasMonitoring1<>((b) -> b.equals(2L), 2L);
            l.add(longb);
            TimeUnit.SECONDS.sleep(1);
        }

//        Math.signum()
    }

}

class DumpForLambdasMonitoring1<T> {
    DumpForLambdasMonitoring1(a<T> a, T b) {
        a.compare(b);
    }
}

@FunctionalInterface
interface a<T> extends c {
    boolean compare(T o1);
}

interface c extends c1{
//    void a();
}

interface c1 {
}