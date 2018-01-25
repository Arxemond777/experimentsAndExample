package ch6_relations_beetwen_classes;

/**
 * Created by urijglusenkov on 06.12.16.
 */
public class Animal {

    public static void main(String [] args) {
        Cat c = new Cat();
        c.compare();

        A b = new B();
        System.out.println(b.O());
    }

}
interface A {
    abstract int O();
}

class B implements A {
    public int a = 2;

    void A() {

    }

    public int O(){
        return a;
    }

    public int I() {
        return 1;
    }
}

class Cat extends Animal {

    Animal a;
    Cat c;

    public void compare() {
//        System.out.println(a instanceof Cat);
        System.out.println(!(this instanceof Cat));

        boolean b = !(this instanceof Cat);

        if (b) {
            int a = 2;
        }

        int f = 2;

        //A a = new B();
        //A ba = new B();

        System.out.println(Integer.toString(f));

        Cat c = (Cat) a;

        System.out.println(c);
    }

}