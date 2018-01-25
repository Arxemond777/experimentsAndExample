package _a;

import java.util.ArrayList;
import java.util.List;

public class X<T>
{
    public static void main(String[] args) {
        X<Pizda> x = new X<>();
        X<Pizda> x1 = new X<>();

        System.out.println(x.hashCode() + " " + x1.hashCode());

        x.huiX(new Pizda());
    }

    public void huiX(Pizda s) {
    }

}

class Pizda
{

}
