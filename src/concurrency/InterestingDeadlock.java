package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class InterestingDeadlock {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Test test = new Test();
        List<Integer> integerList = new ArrayList<>(Integer.MAX_VALUE/2);

        IntStream.range(0, Integer.MAX_VALUE/2).forEach(integerList::add);

        System.out.println(test.getList());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (Integer integer: integerList) {
            test.add(integer);
            executorService.submit(() -> {
                if (integer % 2 == 0)
                    test.remove(integer);
            }).get();
        }
        System.out.println(test.getList());
    }
}

class Test {
    private final List<Integer> list = new ArrayList<Integer>() {{add(1); add(2); add(3); add(4);}};

    public List<Integer> getList() {
        return  this.list;
    }

    public void add(Integer integer) {
        synchronized (this) {
            this.list.add(integer);
        }
    }

    public void add(List<Integer> addList) {
        synchronized (this) {
            this.list.addAll(addList);
        }
    }

    public void remove(Integer integer) {
        synchronized (this) {
            list.remove(integer);
        }
    }
}