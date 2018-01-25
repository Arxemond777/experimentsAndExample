package _Thing_Java.chapter_12;

public class RecursiveException
{
    static int i = 0;
    
    public static void main(String[] args) {
        
        class CustomException extends Exception
        {

        }

        try {

            System.out.println(0);
            if (RecursiveException.i < 1)
                throw new CustomException();

            System.out.println(1);
            if (RecursiveException.i < 2)
                throw new CustomException();
            System.out.println(2);
        } catch (CustomException e) {
            //System.out.println(e.fillInStackTrace());
            RecursiveException.i++;
            main(args);
            return;
        }

        System.out.println(3);
    }
}
