package test;

/**
 * Created by urijglusenkov on 03.12.16.
 */
public class Car {

    public static void main (String [] args) {

       // X x = new X();

    }

    class X {

        public void abc(int a, int b) {
            Y y = new Y(a, b);
        }
    }

    class Y {

        int a, b;

        Y (int a, int b) {

        }

        Y (int a) {
            this(1, 2);
        }


    }
}
