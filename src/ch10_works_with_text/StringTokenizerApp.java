package ch10_works_with_text;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Служит для расспарсивания
 */
public class StringTokenizerApp {
    String text = "4231, JAVA\nPROGRAMMING, 10,1f";

    public static void main(String[] args) {
        StringTokenizerApp sta = new StringTokenizerApp();
        StringTokenizer st = new StringTokenizer(sta.text);

        while (st.hasMoreElements())
            System.out.println(st.nextToken());
        System.out.println("_____________________");

        StringTokenizer stWithComma = new StringTokenizer(sta.text, ",");

        while (stWithComma.hasMoreElements())
            System.out.println(stWithComma.nextToken().trim());

        Class sr = StringTokenizer.class;
        Method[] srAllMethod = sr.getDeclaredMethods();
        System.out.println(Arrays.toString(srAllMethod));

    }
}
