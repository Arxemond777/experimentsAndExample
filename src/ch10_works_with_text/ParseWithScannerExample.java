package ch10_works_with_text;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ParseWithScannerExample {
    public static void main(String[] args) throws InputMismatchException { //InputMismatchException - если сканер не может парсить строку
        String text = "4231, JAVA PROGRAMMING, 10,1f";
        Scanner scanner = new Scanner(text).useDelimiter("\\s*,\\s*");
        //System.out.println(scanner.nextInt());



        try {

            int a = scanner.nextInt();
            String b = scanner.next();
            float cast = 0;
            if (scanner.hasNext()) {
                //Зона видимости
                cast = scanner.nextFloat();
            }

            System.out.println(a);
            System.out.println(b);
            if (cast != 0)
                System.out.println(cast);
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
        //Integer checkNumber = scanner.nextInt();
        //String description = scanner.next();
        //float amount = scanner.nextFloat();

        //System.out.println(checkNumber);
        //System.out.println(description);
        //System.out.println(amount);
    }
}
