package ch6_relations_beetwen_classes;

class Animals {

    protected int a = 3;

    protected void A() {

    }

}

class Dog extends Animals {

}

class Dogs {}

public class VisibilityModifier {

    public static void main(String [] args) {
        Dog da = new Dog();
        System.out.println(da.a);

        Animals a = new Dog();

        Animals animals =  new Animals();
        Dog dogs = (Dog) a; //Так можно, потому что тип у а Animals но реализация Dogs
        //Dog dogs1 = a; //Так нельзя, потому что должно быть явное приведение типов, как выше
        Dog dogses = (Dog) animals; //Так нельзя, потому что animals это ссылка на Animals


        System.out.println(animals.getClass().getSuperclass().getSimpleName());
        /*Dogs ds = new Dogs();
        System.out.print(ds.a);*/

    }

}
