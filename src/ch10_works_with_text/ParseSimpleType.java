package ch10_works_with_text;

import java.util.Locale;
import java.util.Scanner;

public class ParseSimpleType {
    public static void main(String[] args) {
        byte b = new Scanner("16").nextByte();
        System.out.println(b);

        /** Similar */
        long l = Long.parseLong("cafebabe", 16);
        System.out.println(l);

        long l1 = new Scanner("cafebabe").nextLong(16);
        System.out.println(l1);
        /** ________ */

        String s = Long.toString(l1, 16);
        System.out.println(s);

        /** Работа метода HEX */
        String hex = Integer.toHexString(255).toUpperCase();
        System.out.println(hex);
        /**____*/

        double d = new Scanner("1.234,56")
                .useLocale(Locale.ITALIAN)
                .nextDouble();
        System.out.println(d);
        /** _______ */

        /** Флаг альтернативного варианта для вывода 8 или 16 чила */
        System.out.printf("%1$x, %1$#x\n", 0xCAFE, 0xCAFE);//$#x для 16 с сдандартным префиксом 0x
        System.out.printf("%1$o, %1$#o", 8, 8);//$#o для 8 с сдандартным префиксом 0 для 8-ого

    }
}
