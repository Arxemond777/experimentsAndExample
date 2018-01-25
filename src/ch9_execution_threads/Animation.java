package ch9_execution_threads;

public class Animation implements Runnable {

    boolean animate = true;
    Thread myThread;

    Animation(String name) {
        myThread = new Thread(this);
        myThread.start();
    }

    public static void main() {
        Animation animation = new Animation("Something");
        /*Thread myThread = new Thread(animation);
        myThread.start();*/

    }

    public void run() {
        while (animate) {

        }
    }

    public void startAnimate() {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                drawFrames();
            }
        });
        myThread.start();
    }

    void drawFrames() {}
}

