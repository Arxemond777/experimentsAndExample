package ch4_language_java;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.util.List;
//import java.awt.*;

public class forArray {

    public static void main (String [] args) {
        int [] arrayOfInts = new int [] {1,2,3,4};
        for (int i : arrayOfInts)
            System.out.println(i);
        System.out.print("s");
        List<String> list = new ArrayList<String>();
        list.add("Foo");
        list.add("Bar");
        for (String s : list)
            System.out.println(s);

        Object xer = null;
        switch (2) {
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            default:
                System.out.println(3);
        }

        System.out.println(false ^ false);

        String str = "foo";
        //System.out.println(str instanceof Date);

        a a = new a();
        a.d();

    }

}

class a {

    void a() {

        try {
            throw new IOException("1");

        } catch (IOException cause) {

            IOException e = new IOException("23");
            cause.initCause(e);

            System.out.println("1-" +cause);
//            throw e;

        }

    }

    void d() {
        int [] newArray = new int[20];

        //newArray = ArrayUtils.removeElement(newArray, 1);
        //newArray = Ar
        //newArray.remove(19);
        System.out.println("69: " + newArray[19]);

        String [] newStringArray = {"1", "2"};
//        System.out.println(Arrays.toString(newStringArray));

        java.awt.Button [] newButton = new java.awt.Button[10];
        for (int i = 0; i < newButton.length; ++i)
            newButton[i] = new Button(Integer.toString(i));

        //for (Button newButtonVal : newButton)
        //    System.out.println(newButtonVal);

        java.awt.Button [] testCopy = java.util.Arrays.copyOf(newButton, newButton.length-1);

        System.out.println(Arrays.toString(testCopy));
//        System.out.println(Arrays.toString(newButton));

        String [][][] a = new String[1][][];
    }

    void c(int c) {
        assert false;

        System.out.println(12);
    }

    void b () {

        //assert false : "asad";
        String foo1 = null;
        //assert foo1 != null : "foo равно ноль";
        assert foo1 == null : "foo равно ноль";

        System.out.println(1);
        int foo;

        try {
            foo = 123;
        } catch (Exception e) {
            return;
        }

        int bar = foo;

    }

}
