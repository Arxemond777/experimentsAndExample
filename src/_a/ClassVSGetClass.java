package _a;

import java.util.Arrays;

public class ClassVSGetClass
{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<Alala> a = Alala.class;
        System.out.println(a); // class Возвращает Обьект класса Class
        System.out.println(a.newInstance().i);

        System.out.println("___________________");

        Class <? extends Alala> b = new Blalal().getClass();
        System.out.println(b);
        System.out.println(b.newInstance());

        int []aa = {1, 2, 3};
        int []bb = aa;

        aa[1] = 222;

        System.out.println(Arrays.toString(aa));
        System.out.println(Arrays.toString(bb));
    }
}

class Alala
{
    public int i = 2;
}

class Blalal extends Alala
{

}
