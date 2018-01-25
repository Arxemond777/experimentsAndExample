package ch9_execution_threads;

import java.util.*;

public class Consumer implements Runnable
{

    Producer producer;

    Consumer(Producer producer) {
        this.producer = producer;
    }

    public void run() {

        while (true) {
        System.out.println(producer.getMessage());
            String message = producer.getMessage();
            System.out.println("Got message: " + message);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception Consumer");
            }
        }
    }

    public static void main(String [] args) {
        Producer producer = new Producer();
        new Thread(producer).start();

        Consumer consumer = new Consumer(producer);
        new Thread(consumer).start();
    }

}

class Producer implements Runnable
{

    static final int MAXQUEUE = 5;
    private List messages = new ArrayList();

    public void run() {
        while (true) {
            putMessage();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception Producer 1");
            }
        }
    }

    private synchronized void putMessage() {
        while (messages.size() >= MAXQUEUE)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception Producer 2");
            }

        messages.add(new java.util.Date().toString());
//        notify(); //для NamedConsumer не подходит
        notifyAll();
    }

    public synchronized String getMessage() {
        while (messages.size() == 0)
            try {
                //        notify(); //для NamedConsumer не подходит
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception Producer 3");
            }

        String message = (String)messages.remove(0);
        //        notify(); //для NamedConsumer не подходит
        notifyAll();
        return message;
    }

}