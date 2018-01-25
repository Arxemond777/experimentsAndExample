package ch9_execution_threads;

import java.lang.ThreadLocal;
import java.util.concurrent.*;

public class ThreadLocalAndFutures_01_03_17
{
    public static void main(String[] args) {
        ThreadLocalExample.example();
//        FuturesExample.example();
    }
}

/**
 * ThreadLocal ThreadLocal переменные отличаются от обычных переменных тем,
 * что у каждого потока свой собственный, индивидуально инициализируемый экземпляр переменной
 *
 * А еще можно работать со static переменной так
 * http://articles.javatalks.ru/articles/17
 */
class StaticThreadLocal
{
    private static final ThreadLocal<String> threadLocalScope = new  ThreadLocal<>();

    public final static String getLoggedUser() {
        return threadLocalScope.get();
    }

    public final static void setLoggedUser(String userName) {
        threadLocalScope.set(userName);
    }
}

class ThreadLocalExample
{
    static void example() {
        ThreadLocal userId = new ThreadLocal();
        userId.set("Bob");
        StaticThreadLocal.setLoggedUser("Ivan");

        new Thread(new Runnable()
        {
            @Override
            public void run() {
                //Не дает перезатереть
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(
                    "Name thread: " + Thread.currentThread().getName()
                    + " | " + userId.get()
                    + " | " + StaticThreadLocal.getLoggedUser()
                );
            }
        }).start();

        System.out.println(
                "Name thread: " + Thread.currentThread().getName()
                + " | " + userId.get()
                + " | " + StaticThreadLocal.getLoggedUser()
        );
    }
}

class FuturesExample
{
    static void example() {
        ExecutorService e = Executors.newFixedThreadPool(2);

        //Callable
        Future<String> future = e.submit(() -> {Thread.sleep(100); return "1"; });
        //Analogue
        Future<String> future1 = e.submit(new Callable<String>()
        {
            @Override
                public String call() throws Exception {
                Thread.sleep(100);
                return "2";
            }
        });

        try {
            System.out.println(future.get());
            System.out.println(future1.get());
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}