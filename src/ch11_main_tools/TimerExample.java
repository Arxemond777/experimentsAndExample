package ch11_main_tools;

import java.util.*;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimerExample
{
//    public enum Weekday {
//        Sunday(8), Monday(0), Tuesday(1);
//        int fun;
//        Weekday(int fun) {this.fun = fun;}
//        int getFun(){return fun;}
//    }

    public static <E> E A(E i){
        return i;
    }
    public static void main(String[] args) {
        String te = TimerExample.A("a");
        System.out.println(te.getClass().getName());
        System.exit(0);
//        Integer i = new Integer("1");//запаковка примитива
//        System.out.println(i.intValue() instanceof Integer);//распаковка примитива
//        System.out.println(Weekday.Monday.getFun());
//        System.exit(0);
        TimerExample timerExample = new TimerExample();
        timerExample.timer1();
//        timerExample.timer2();

        t = executor.scheduleAtFixedRate(new MyTask(), 0, 1, TimeUnit.SECONDS);
    }

    void timer1() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask()
        {
            @Override
            public void run() {
                System.out.println("C новым милениумом");
            }
        };

        Calendar calendar = new GregorianCalendar(2000, Calendar.JANUARY, 1);
        timer.schedule(timerTask, calendar.getTime());
    }

    static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(15); // no
    static ScheduledFuture<?> t;
    private  int attempt = 1;

//    void timer2() {
//        Timer timer = new Timer();
//
//        TimerTask timerTask = new TimerTask()
//        {
//            @Override
//            public void run() {
//                if (attempt > 5) {
//                    return t.cancel(false);
//                }
//                ++attempt;
//                System.out.println(new Date());
//            }
//        };
//
//        //t = timer.scheduleAtFixedRate(timerTask, 0, 1000);
//    }
    static class MyTask implements Runnable {
        private int attempt = 1;

        public void run() {
            System.out.print(attempt + " ");
            if (++attempt > 5) {
                t.cancel(false);
            }
        }
    }
}
