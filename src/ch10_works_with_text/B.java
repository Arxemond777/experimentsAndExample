package ch10_works_with_text;

import java.util.*;

public class B {
    public static void main(String[] args) {
        String string = "a";
        boolean b = string.isEmpty();

        System.out.println(string.isEmpty());
        if (string.isEmpty()){}

        String s = new String("Hello World");
        for (int i = 0; i < s.length(); ++i)
            System.out.println(s.charAt(i));

        char [] alphabit = "abcdef".toCharArray();
        System.out.println(Arrays.toString(alphabit));

        char a = 'a';
        System.out.println(String.valueOf(a));

        As as = new As();
        System.out.println(String.valueOf(as));

        Ass ass = new Ass();
        System.out.println(ass);
        System.out.println(String.valueOf(ass));

        Date date = new Date();
        date = null;
        System.out.println(String.valueOf(date) == "null");//true сылаются оба на стринг
        System.out.println(String.valueOf(date).equals("null"));//true равен строке "null"
        System.out.println(String.valueOf(date) == null);//false не арвны ссылки на объект
        System.out.println(String.valueOf(date).equals(null));//false не равна ключевому слову null
    }
}

class As {
    @Override
    public String toString() {
        return "ad";
    }
}

class Ass {

}