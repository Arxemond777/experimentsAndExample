package _Thing_Java;

public class X {
    public static void main(String[] args) {
        new Children();
    }
}

class Children extends Parent {

    public Children() {
        i = 2;
        System.out.println(super.i);
    }

    @Override
    public void parentFunc() {
        i.equals(super.i);
    }
}

abstract class Parent {

    Integer i = null;

    public Parent(){
        System.out.println(i);
        // i in the child had`t been initialisation yet
        parentFunc(); // Exception can be not initialisation -> Null pointer
    }

    public abstract void parentFunc();
}