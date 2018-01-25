package ch9_execution_threads;

public class Devil extends Thread {
    Devil() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {

    }
}
