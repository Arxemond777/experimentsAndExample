package ch9_execution_threads;

public class NamedConsumer implements Runnable
{
    Producer producer;
    String name;

    NamedConsumer(String name, Producer producer) {
        this.name = name;
        this.producer = producer;
    }

    public void run() {
        while (true) {
            String message = producer.getMessage();
            System.out.println(name + " got message: " + message);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.print("Interrupted Exception in NamedConsumert");
            }
        }
    }

    public static void main(String [] args) {

        Producer producer = new Producer();
        new Thread(producer).start();

        new Thread(new NamedConsumer("One", producer)).start();
        new Thread(new NamedConsumer("Two", producer)).start();

        /**
         * Это делается в разных потоках, это как бы локальные переменные для каждого потока, когда они
         * должны быть уникальными
        **/
        /*ThreadLocal userID = new ThreadLocal();
        userID.set(1);
        userID.set(2);
        userID.get();
        userID.get();*/
    }

}
