package binaryoperations;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class ExampleOverflowInteger {
    public static void main(String[] args) {
        System.out.println(MAX_VALUE);
        System.out.println(MAX_VALUE+1);
        System.out.println(MAX_VALUE+MAX_VALUE);
        System.out.println(MAX_VALUE+MIN_VALUE);
    }
}
