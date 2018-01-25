package ch9_execution_threads;

import java.util.Arrays;

public class Test {
    public static void main (String[] args) {
        Test.a("a", "2");
    }

    static void a(String... args ) {
        System.out.println("x: " + Arrays.toString(args));
    }
}
