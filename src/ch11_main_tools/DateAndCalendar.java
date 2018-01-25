package ch11_main_tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

public class DateAndCalendar
{
    public static void main(String[] args) throws InterruptedException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        Calendar calendar = Calendar.getInstance();
        System.out.println(gregorianCalendar + " \ndifferent + \n" + calendar);

        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, 1994);
        birthday.set(Calendar.MONTH, Calendar.FEBRUARY);
        birthday.set(Calendar.DATE, 17);

        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        cal.add(Calendar.WEEK_OF_YEAR, 4);
        System.out.println("+4 week: " + cal.getTime());

        System.out.println(calendar.getTime());
        //Thread.sleep(2000);
        calendar.setTime(new Date());
        System.out.println(calendar.getTime());
        System.out.println(Thread.currentThread());

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(TimeZone.getTimeZone("US/Mountain"));
        System.out.println("US/Mountain: " + gc.get(Calendar.HOUR));

        Calendar cUSA = Calendar.getInstance(TimeZone.getTimeZone("America/Chicago"));
        System.out.println("America/Chicago: " + cUSA.get(Calendar.HOUR));

        DateFormat dateFormat = DateFormat.getInstance();
        String now = dateFormat.format(new Date());
        System.out.println(now);

        DateFormat dateFormatDate = DateFormat.getDateInstance(DateFormat.DEFAULT, new Locale("ru"));
        DateFormat dateFormatTime = DateFormat.getTimeInstance(DateFormat.DEFAULT, Locale.GERMAN);
        DateFormat dtf = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.ITALY);

        try {
            DateFormat dfParse = DateFormat.getDateInstance();
            System.out.println(dfParse.parse("Sat Jan 21 17:24:49 MSK 2017"));
        } catch (ParseException pe) {
        } catch (NullPointerException npe) {
        } catch (StringIndexOutOfBoundsException se) {
        }

        System.out.printf(new Locale("ru"), "Дата: %1$TF %1$TH:%1$TM:%1$TS\n", new Date());
    }
}
