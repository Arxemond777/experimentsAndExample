package _Gerbert_Schildt_java_8.ch8_package_and_interface;

import com.sun.istack.internal.NotNull;

public class Example
{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Abc abc = Abc.class.newInstance();
        System.out.println(
                "Default method: " + abc.abc() + System.lineSeparator()
                + "Static interface% " + Default.def() + System.lineSeparator()
                + " | " + abc.i()
        );
    }
}

interface Default
{
    default double abc() {
        return Math.random();
    }

    @A(intVal = 3)
    static int def() {
        return 666;
    }
}

class Abc implements Default
{
    @NotNull
    protected int i() {
        return Integer.parseInt(null);
    }
}

@interface A {
    int intVal();
}