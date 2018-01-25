package ch10_works_with_text;

import java.text.ChoiceFormat;

/**
 * Удобен, например, для преобразование во множественное число. У вас открыт 1 фай (файдлв)
 */

public class ChoiceFormatApp {
    public static void main(String[] args) {
        double[] limits = new double[] {0, 20, 40};
        String[] labels = new String[] {"молодой", "менее молодой", "старый"};
        ChoiceFormat cf = new ChoiceFormat(limits, labels);
        System.out.println(cf.format(-1));
        System.out.println(cf.format(12));
        System.out.println(cf.format(26));
        System.out.println(cf.format(39));
        System.out.println(cf.format(40));
        System.out.println("______________________");

        ChoiceFormat cfExtend = new ChoiceFormat("0#молодой|20#менее молодой|40#старый");
        System.out.println(cfExtend.format(39));
    }
}
