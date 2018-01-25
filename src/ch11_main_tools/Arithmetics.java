package ch11_main_tools;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class Arithmetics
{
    public static void main(String[] args) {
        long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

        int zero = 0;

        {
           int t = zero;
        }

        try {
            double i = -1.0 / zero;
            System.out.println(i == Double.NEGATIVE_INFINITY);
        } catch (ArithmeticException e) {

        }

        System.out.println(Math.signum(0) == 0 );
        System.out.println(Math.PI);

        try {
//            BigDecimal bd1 = new BigDecimal("643520462377623432647623647632874");
//            BigDecimal bd2 = new BigDecimal("54739678624176545641506");

            BigDecimal b1 = new BigDecimal(1);
            BigDecimal b2 = new BigDecimal(3);
            BigDecimal d = b1.divide(b2, 100, BigDecimal.ROUND_UP);
            System.out.println(d);
        } catch (NumberFormatException nfe) {}
        catch (ArithmeticException ae) {}

        long f = 999_999_995_904L;
        float trillionish = (float)f;
        System.out.println(trillionish);

        float ULP = Math.ulp(f);
        float NEXT = Math.nextUp(trillionish);

        System.out.println(ULP);
        System.out.println(NEXT);

        String s = new Scanner(new Float(NEXT).toString()).useDelimiter("\\A").next();

        System.out.println(s + " in Bits convert = " + Float.floatToIntBits(trillionish));
        System.out.println("Program used: " + usedBytes / 1048576 + " MB");
        System.out.println(new Float(trillionish).intValue());//ошибочка

        Random random = new Random(1);
        System.out.println("Random: " + Math.abs(random.nextInt()));
        System.out.println(Math.random());//равносильно random.nextDouble() с дефолтным конструктором
        System.currentTimeMillis();
    }
}
