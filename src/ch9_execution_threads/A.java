package ch9_execution_threads;

public class A
{
    public static void main(String [] args) {
        ThreadGroup tg = new ThreadGroup("current group");

        Thread th = new Thread(tg, new ShowThread("Foo"));
        Thread th1 = new Thread(tg, new ShowThread("Bar"));
        th.start();
        th1.start();

        th.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t + "throw exception :" + e);
            }
        });

        //tg.uncaughtException(Thread th, );
        /*System.out.println(th1.getThreadGroup().getName());
        System.out.println(tg.getParent());*/
        //tg.checkAccess();
        /*ShowThread sh1 = new ShowThread("Foo");
        sh1.setPriority(Thread.MIN_PRIORITY);

        ShowThread sh2 = new ShowThread("Bar");
        sh2.setPriority(Thread.MAX_PRIORITY);
        sh1.start();
        sh2.start();*/

    }

}

class ShowThread extends Thread
{
    String message;

    ShowThread(String message) {
        this.message = message;
    }

    public void run() {
        /*while (true) {
            System.out.println(message + " : " + Thread.currentThread().getState());
            yield();
        }*/
    }
}