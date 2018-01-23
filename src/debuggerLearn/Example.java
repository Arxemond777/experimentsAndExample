package debuggerLearn;

class B {
    int C() {
        return 1;
    }
}

public class Example {
    public static void main(String[] args) {
        String s = "Hi221";
        System.out.println("1");
        System.out.println(s);
        Double d = null;
        double d1 = 2;
        double d3 = 666;
        d3 = A(d);
        double d999 = A(d);
        System.out.println(d3);
        d = 2.0;
        double d2 = 1;

        B b = new B();
        int bInt = b.C();

        System.out.println("B int " + bInt);

        d = 4.0;
        System.out.println(d);
    }

    public static Double A(Double d) {
        double d8 = 3;
        d8 = d8 + 3;
        return d = 3.0;
    }
}
