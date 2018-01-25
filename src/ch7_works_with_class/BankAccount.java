package ch7_works_with_class;

import java.lang.reflect.Field;

class BankAccount1 {
    public int balance = 2;
}

public class BankAccount {
    public static void main(String [] args) {
        BankAccount1 ba = new BankAccount1();

        try {
            Field f = BankAccount1.class.getField("balance");

            int myBalance = f.getInt(ba);

            System.out.println(myBalance);
            f.setInt(ba, 42);

            myBalance = f.getInt(ba);
            System.out.println(myBalance);

        } catch (NoSuchFieldException e) {

        } catch (IllegalAccessException e) {

        }

    }
}
