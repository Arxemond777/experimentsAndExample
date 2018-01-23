package concurrency;

import java.util.concurrent.TimeUnit;

public class DeadlockExample {
    private static final Object
            object1 = new Object(),
            object2 = new Object();

    public static final int delay = 3;


    static void object1() {
        System.out.println("object " + Thread.currentThread().getName());
        while (true) {
            try {
                TimeUnit.MICROSECONDS.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1) {
                synchronized (object2) {
                    object2();
                }
            }
        }
    }


    static void object2() {
        System.out.println("object " + Thread.currentThread().getName());
        while (true) {
            try {
                TimeUnit.MICROSECONDS.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2) {
                synchronized (object1) {
                    object1();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread
                thread1 = new Thread(DeadlockExample::object1, "1"),
                thread11 = new Thread(DeadlockExample::object1, "11"),
                thread111 = new Thread(DeadlockExample::object1, "111"),
                thread1111 = new Thread(DeadlockExample::object1, "111"),
                thread2 = new Thread(DeadlockExample::object2, "2"),
                thread22 = new Thread(DeadlockExample::object2, "22"),
                thread222 = new Thread(DeadlockExample::object2, "222"),
                thread2222 = new Thread(DeadlockExample::object2, "2222");

        thread1.start();
        thread11.start();
        thread111.start();
        thread1111.start();
        thread2.start();
        thread22.start();
        thread222.start();
        thread2222.start();
    }
}
