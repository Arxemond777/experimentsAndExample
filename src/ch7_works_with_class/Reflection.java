package ch7_works_with_class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {

    public static void main(String [] args) {
        Method[] methods = Class.class.getMethods();

        for (Method method : methods) {
//            System.out.println(method);
        }

        String var1 = "ch7_works_with_class.Var";

        try {
            Class newClass = Class.forName(var1);
            Var var = (Var)newClass.newInstance();

            Constructor [] c =  Var.class.getConstructors();
            System.out.println(Arrays.toString(c));

            System.out.println(var.a);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " Exception");
        }

    }

}

class Variable {

    public int a = 3;

    public Variable(int f) {

        this.a = f;

    }

}

class Var extends Variable{

    public Var() {
        super(7);
    }
    protected void A(){}

}
