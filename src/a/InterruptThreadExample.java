package a;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicLong;

public class InterruptThreadExample {

    private static AtomicLong atomicLong = new AtomicLong();

    private static final Long target = 300L;

    private final static Object object = new Object();
    private static Boolean bool = true;

    private static Thread consumer;

    private static PipedOutputStream pout;
    private static PipedInputStream pin;

    public static void main(String[] args) throws IOException {

        /*while (atomicLong.get() < target) {

            Thread thread = new Thread(() -> {

                synchronized (object) {
                    atomicLong.incrementAndGet();

                    System.out.println(atomicLong.get());

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();

            if (atomicLong.get() < target - 50) {
                thread.interrupt();
            } else {
                synchronized (object) {
                    new Thread(object::notifyAll).start();
                }
            }
        }*/

        consumer();
    }

    private static void consumer() {

        consumer = new Thread(() -> {
            synchronized (object) {
                while (!Thread.currentThread().isInterrupted() /*bool*/) {

                    try {
                        System.out.println(atomicLong.incrementAndGet());

                        handler();
                        object.wait();
                    } catch (InterruptedException e) {
                        System.out.printf("Atomic is equal: (%d)" + System.lineSeparator(), atomicLong.get());
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        consumer.start();
    }

    private static void handler() {
        new Thread(() -> {
            synchronized (object) {
                try {

                    if (atomicLong.get() >= target - 50) {
//                        bool = false;
                        consumer.interrupt();
                    }
                    Thread.sleep(10);
                    object.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
