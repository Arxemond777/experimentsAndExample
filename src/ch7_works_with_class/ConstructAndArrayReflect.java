package ch7_works_with_class;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Date;

public class ConstructAndArrayReflect {
    public static void main(String [] args) {
        try {
            Constructor<Date> cons = Date.class.getConstructor(String.class);
            Date date = cons.newInstance("Jan 1, 2006");
            System.out.println(date);

            //Array
            int length = 2;
            int[] x = {length};
            Array.newInstance(int.class, x);

            System.out.println(Arrays.toString(x));

            int[] intArray = (int[]) Array.newInstance(int.class, 3);
            System.out.println(Arrays.toString(intArray));
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        } catch (InstantiationException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            System.out.println(e.getTargetException());
        }
    }
}
