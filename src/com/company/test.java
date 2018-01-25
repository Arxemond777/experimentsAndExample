package com.company;

//import com.sun.tools.internal.xjc.api.ClassNameAllocator;

import java.util.Arrays;

/**
 * Created by urijglusenkov on 19.11.16.
 */
interface A {
    public void ab();
}

public class test implements A {
    public static void main(String[] args) {
        int a = 2;
        double b = 2.0;

        if (a == b) System.out.println(1);

        baa.bc(new c());

        System.out.println(Arrays.toString(args));

        java.lang.String test = System.getProperty("test");// cd ~/InteliJ/HelloWorld/out/production/HelloWorld/ && java -Dtest com.company.test
        System.out.println("-Dtest = " + test);

        child child = new child();
        child.info();
        //b.bc(new c());
    }

    public void ab() {
    }
}

class c implements A {
    public void ab() {
        System.out.println('c');
    }
}

class baa {

    public static void bc(A a) {
        a.ab();
        System.out.println(123);
    }
}

class parent {
    public int i = 1;
}

class child extends parent {
    public int i = 2;

    public void info() {
        System.out.print(super.i + " " + this.i);
    }

}