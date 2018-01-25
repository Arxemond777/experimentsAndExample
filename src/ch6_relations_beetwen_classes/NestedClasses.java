package ch6_relations_beetwen_classes;

public class NestedClasses {

    int A = 1;
    public static enum X {
        A(1), B(3);

        int i;

        X(int i) {
            this.i = i;
        }

        int getI() {
            return i;
        }
    };

    public static void main (String [] args) {
        Abc abc = new Abc();
        System.out.println(abc.a().a);

        Abc.T t = abc.new T();
        System.out.println(t.a);

        System.out.println("Get enum: " + X.A.getI());
    }

    Thread getThread() {

        return new Thread() {

            public void run() {
                int a = 2;
            };//.start();

        };

    }

}

class Abc {

    T a () {
        T t = new T();
        return t;
    }

    class T {
        int a = 2;
    }

    class A {
        //final Integer asd = 2;//ТАК МОЖНО
        //static int A = 1;//Так нельзя!! Внутренние классы не могут быть статик
        //enum B {B}// И перечислениями тож нельзя
//        public interface Rrr {}//И так нельзя, ибо интерпитируется так public static interface Rrr {}, а статик незя
    }

}

