package ch10_works_with_text;

import java.text.*;
import java.util.Locale;

public class JavaText {
    public static void main(String[] args) {
        double salary = 1234.56;
        String here = NumberFormat.getCurrencyInstance(Locale.US).format(salary);
        String italy = NumberFormat.getCurrencyInstance(Locale.ITALIAN).format(salary);

        System.out.println("From " + Locale.getDefault().getDisplayCountry() + ": " + here);
        System.out.println("From " + Locale.ITALIAN.getDisplayLanguage() + ": " + italy);

        double progress = 0.44;
        NumberFormat nf = NumberFormat.getPercentInstance(Locale.US);//эвкивалент getInstance
        System.out.println(nf.format(progress));

        try {
            System.out.println(nf.parse("77.2%")); //с locale US работает, с РУ нет
        } catch (ParseException e) {
            System.out.println(e);
        }

        NumberFormat q = NumberFormat.getInstance(Locale.ITALIAN);
        NumberFormat j = NumberFormat.getInstance();

        try {
            double theValue = q.parse("34.663,252").doubleValue();
            System.out.println(j.format(theValue));
        } catch (ParseException e) {}
    }
}
