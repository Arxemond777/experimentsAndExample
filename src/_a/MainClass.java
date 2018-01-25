package _a;

public class MainClass
{
    public static void test(int ...a){
        System.out.println(1);
    }

    public static void test(Integer ...a){
        System.out.println(2);
    }

    /*public static void test(Number ...a){
        System.out.println(3);
    }*/

    public static void test(Object ...a){
        System.out.println(4);
    }

    @SuppressWarnings("unused")
    public static void main(String args[]) {
        int i1 = 012;
        int i2 = 20;
        System.out.println(i1 * i2);
        Number n = new Integer(1);
//        test(n.intValue()); //Если убрать varargs у test(int - то test(int
        // А вообще компилятор не может выбрать более верный тип между int и Integer
    }
}