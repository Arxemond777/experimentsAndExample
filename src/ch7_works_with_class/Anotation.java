package ch7_works_with_class;

/**
 * Created by urijglusenkov on 02.01.17.
 */
public class Anotation {
    public static void main(String[] args) {
        String s = "ch7_works_with_class.Anotation";

        try {
            Class a = Class.forName(s);
            Anotation an = (Anotation) a.newInstance();
            an.a();

        } catch (ClassNotFoundException e) {

        } catch (Exception e) {

        }

        try {
            String str = "ch7_works_with_class.b";
            Class ass = Class.forName(str);
            b b = (b)ass.newInstance();
            //System.out.println(b.toString());
            b.c();

        } catch (ClassNotFoundException e) {

        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }


        System.out.println(1);
        System.exit(1);
    }

    @Deprecated
    public void a() {
        System.out.println(2);
    }
}

class a {
    public void c() {
        System.out.println("parent " + this.getClass().getSimpleName());
    }
}

class b extends a {
//    public String toString(int a) {
//        return "b " + a;
//    }
    @Override //Не дает совершить ошибку в сигнатуре переопределяемого метода, чтоб случайно не перезагрузить его
    public void c() {
        System.out.println("children " + this.getClass().getSimpleName());
    }
}
