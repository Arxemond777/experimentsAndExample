package _Gerbert_Schildt_java_8.ch14_lambda_and_link_on_method.ref_on_method;

@FunctionalInterface
interface IntPredicate2
{
    boolean test(MyIntNum2 mv, int i);
}

class MyIntNum2 {
    private int v;

    MyIntNum2(int v) {
        this.v = v;
    }

    MyIntNum2() {
        this(0);
    }

    int getV() {
        return v;
    }

    boolean isFactory(int n) {
        return (v % n) == 0;
    }
}

public class MethodRefDemo2
{
    public static void main(String[] args) {
        boolean result;
        IntPredicate2 ip;

        MyIntNum2
                myIntNum = new MyIntNum2(12),
                myIntNum1 = new MyIntNum2(16);

        ip = MyIntNum2::isFactory;
        System.out.println(myIntNum1.getV() + " / 3: " + ip.test(myIntNum, 3));

        ip = MyIntNum2::isFactory;
        System.out.println(myIntNum1.getV() + " / 3: " + ip.test(myIntNum1, 3));
    }
}
