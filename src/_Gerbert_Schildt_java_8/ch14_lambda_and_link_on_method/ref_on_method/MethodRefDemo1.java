package _Gerbert_Schildt_java_8.ch14_lambda_and_link_on_method.ref_on_method;

@FunctionalInterface
interface IntPredicate1
{
    boolean test(int i);
}

class MyIntNum {
    private int v;

    MyIntNum(int v) {
        this.v = v;
    }

    MyIntNum() {
        this(0);
    }

    int getV() {
        return v;
    }

    boolean isFactory(int n) {
        return (v % n) == 0;
    }
}

public class MethodRefDemo1
{
    public static void main(String[] args) {
        boolean result;
        IntPredicate1 ip;

        MyIntNum
                myIntNum = new MyIntNum(12),
                myIntNum1 = new MyIntNum(16);

        ip = myIntNum::isFactory; // Метод с совбадающий сигнатурой с функциональным интерфейсом в myIntNum::isFactory
        System.out.println("12 / 3: " + ip.test(3));

        ip = myIntNum1::isFactory;
        System.out.println("16 / 3: " + ip.test(3));
    }
}
