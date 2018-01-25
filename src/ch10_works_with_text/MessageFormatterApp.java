package ch10_works_with_text;

import java.text.MessageFormat;

public class MessageFormatterApp {
    public static void main(String[] args) {
        MessageFormat mf = new MessageFormat("У вас {0, number, integer} сообщений на  {1, date, long}.");

//        System.out.println(mf.format(93, new Date()));

        MessageFormat mf1 = new MessageFormat("У вас {0, number, integer} сообщений на  {1, choice, 0#s|1#|2#s}.");
        //System.out.println(mf1.format(new Integer(1)));
    }
}
