package ch9_execution_threads;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    public static void main(String[] args) throws Exception {
        Callable<Integer> callable = new Callable<Integer>() { //Анонимный класс
            @Override
            public Integer call() {
                return 2 + 2;
            }
        };

        //System.out.println(callable.getClass());
        System.out.println(callable.call());
    }

    public Integer call() {
        return 2 + 2;
    }


}

class MyCallable1 implements Callable<Integer> { //Просто класс

    @Override
    public Integer call() throws Exception {
        return 2 + 2;
    }
}