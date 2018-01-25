package ch9_execution_threads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class CallableRunnable {
    public static void main(String[] args) throws Exception {
        CallableRunnableExample cre = new CallableRunnableExample();
        cre.a();
    }
}

class R implements Runnable {

    @Override
    public void run() {
        System.out.println(1);
        for (int i = 0; i < 10000; ++i) {}
    }
}

class CallableRunnableExample {
    Callable a() throws Exception {
        Callable<Integer> callable = Executors.callable(new R(), 42);
        System.out.println(callable.call());
        return callable;
    }
}