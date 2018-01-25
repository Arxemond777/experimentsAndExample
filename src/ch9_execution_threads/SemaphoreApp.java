package ch9_execution_threads;

import java.util.concurrent.Semaphore;

public class SemaphoreApp {
    int concurrentReader = 5;
    boolean fair = true;
    Semaphore semaphore = new Semaphore(concurrentReader, fair);

    Data readData() throws InterruptedException {
        Data data = new Data();
        semaphore.acquire();

        semaphore.release();

        return data;
    }

    private class Data {
    }
}
