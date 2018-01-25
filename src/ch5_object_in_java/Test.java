package ch5_object_in_java;

import static ch5_object_in_java.Weekdays.*;
//import static java.util.Calendar.SECOND;

public class Test {

    public static void main(String [] args) throws InterruptedException {
        System.out.println(Weekdays.Monday);

        Weekdays [] weekdays = Weekdays.values();
        System.out.println(weekdays);

        String mondayString = Weekdays.Monday.name();
        Weekdays a = Enum.valueOf(Weekdays.class, "Monday");//Поиск по

        //SECONDS.sleep(5);
        System.out.println("- " + mondayString);
        System.out.println("- " + a);

        //A A = new A();

        //System.out.println(Weekdays.getFun());
    }

    class A {
        int a;
        A() {
           a = Wednesday.getFun();
        }
    }

}
