package ch10_works_with_text;

import java.util.Arrays;
import java.util.Locale;

public class С {
    public static void main(String[] args) {
        String s1 = new String("c");
        s1 = s1 + "at";
        s1 = s1.intern();
        String s2 = "cat";
        System.out.println(s1 == s2);

        String s3 = "abc";
        String s4 = "abce";
        System.out.println(s3.compareTo(s4));

        char [] s50 = new char [] {'a', 'b'};
        String s5 = "adr";
        s5 = s5.copyValueOf(s50);//копирует с заменной
        System.out.println(s5);

        StringBuilder sb = new StringBuilder("Хей т");
        sb.append('ы');//можно даже жругие типы
        sb.append(1);
        String message = sb.toString();
        System.out.println(message);

        System.out.println(Arrays.toString(Locale.getAvailableLocales()));
        System.out.println(Locale.getDefault());
    }
}
