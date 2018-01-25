package ch5_object_in_java;

/**
 * Created by urijglusenkov on 04.12.16.
 */
public class S {
    public static class C {
        static int i = value();
        static int value() {
            System.out.println("C.i initialized");
            return 1;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Before class loading");
        //Class.forName(C.class.getName());
        System.out.println(C.class.getClassLoader());
        System.exit(1);
        System.out.println("After class loading");
    }
}
