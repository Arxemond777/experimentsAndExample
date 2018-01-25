package ch6_relations_beetwen_classes;

import java.lang.*;

public class ch6 {

    /*ch6_relations_beetwen_classes() {
        ch6_relations_beetwen_classes.test t = new ch6_relations_beetwen_classes.test();
        System.out.print(2);
    }*/

    public static void main (String [] args) {
        test t = new test();


        //TODO если будеть тип ch6_relations_beetwen_classes.test, то значени будет от ch6_relations_beetwen_classes.test, а не от ch6_relations_beetwen_classes.test1
        test1 t1 = new test1();


        test2 t2 = new test2();

        /*System.out.println(t.s);
        System.out.println(t1.s);
        System.out.println(t1.a);
        System.out.println(t2.s);*/

        test t11 = t1;
        System.out.println(t1.getS());
        System.out.println(t11.getS());
    }

}

class test {
    public int s = 3;

    public int getS() throws RuntimeException
    {
        return 1;
    }
}

class test1 extends test {
    public int s = 23;
    int a = super.s;

    /*@Override */public int getS() //throws RuntimeException
    {
        return 2;
    }
}

class test2 extends test1 {
    //double s = 2;
}
