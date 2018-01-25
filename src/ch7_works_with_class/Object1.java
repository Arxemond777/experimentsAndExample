package ch7_works_with_class;

import java.util.HashMap;

/**
 * Created by urijglusenkov on 11.12.16.
 */
public class Object1 {
    HashMap flock = new HashMap();
    int i = 1;
    public Object1() {
        this.i = 2;
    }
    public static void main(String args []) {
        A a = new A();
        System.out.println(a);

        B b = new B();
        System.out.println(b);

        Object1 o1 = new Object1();
        System.out.println(o1.flock);
    }
}

class A {

}

class B {

    public String toString() {
        return "Xer";
    }
}

class C {
    public C getC() {
        return this;
    }

    public C getC1() {
        return new C();
    }
}

class D implements Cloneable {

    HashMap flock = new HashMap();
    public Object clone() {
        try {
            return (D)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error();
        }
    }

}