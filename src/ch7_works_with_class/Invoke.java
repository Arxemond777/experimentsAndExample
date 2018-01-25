package ch7_works_with_class;

import java.lang.reflect.*;
import java.lang.System;

public class Invoke {
    public static void main(String [] args) {
        Integer i = 2;

        System.out.println(i.getClass());
        System.exit(0);
        try {
            Class clas = Class.forName(args[0]);
            Method method = clas.getMethod(args[1]);

            Object ret = method.invoke(null);
            System.out.println(
                    "Invoke static method: " + args[1]
                    + " of class: " + args[0]
                    + " with no args\nResults: " + ret
            );
        } catch (ClassNotFoundException e) {
            System.out.println("1 " + e.getCause());
        } catch (NoSuchMethodException e) {
            System.out.println("2: " + e);
        } catch (IllegalAccessException e) {
            System.out.println("3: " + e);
        } catch (InvocationTargetException e) {
            System.out.println("4: " + e);
        }
    }
}
