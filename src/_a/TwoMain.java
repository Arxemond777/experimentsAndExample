package _a;

import java.util.Arrays;

public class TwoMain
{
    static {
        System.out.println(123);
    }

    {
        System.out.println(1);
    }

    public static void main(String[] args) {
        String[] s = new String[]{new String("a"), new String("b")};
        lala.main(s);
        new TwoMain();

        System.out.println("____________");
        TwoMain twoMain = new TwoMain();
        twoMain.varArgs(new char[]{'1'});
        twoMain.varArgs(new int[]{1});
        twoMain.varArgs();
    }

    static void varArgs(char... c) {
        System.out.println("char: " + Arrays.toString(c));
    }

    static void varArgs(int... i) {
        System.out.println("int: " + Arrays.toString(i));
    }
}

class lala
{
    public static void main(String[] args) {
        for (String s : args)
            System.out.println(s);
    }
}