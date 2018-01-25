package ch10_works_with_text;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExample {

    private static List<String> name = Arrays.asList("peter", "anna", "mike", "xenia");

    public static void main(String[] args) {
        System.out.println(LambdaExample.name);

        notLambda();
        System.out.println(LambdaExample.name);

        lambda();
        System.out.println(LambdaExample.name);
    }

    public static void notLambda() {
        Collections.sort(name, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
    }

    public static void lambda() {
        Collections.sort(name, (String a, String b) -> {
            return a.compareTo(b);
        });

        /** OR */
        //Collections.sort(name, (String a, String b) -> a.compareTo(b));
    }

}
