package ch9_execution_threads;

import java.util.*;
import java.util.concurrent.*;
import java.net.*;
import java.io.IOException;

public class SiteTimer {
    CyclicBarrier barrier;
    List<Result> results = new ArrayList<>();

    private class Result implements Comparable<Result> {
        Long time;
        String site;

        Result(Long time, String site) {
            this.time = time;
            this.site = site;
        }

        public int compareTo(Result r) {
            return time.compareTo(r.time);
        }
    }

    static long timeConnecton(String site) {
        long start = System.currentTimeMillis();
        try {
            new URL(site).openConnection().connect();
        } catch (IOException e) {
            return -1;
        }
        return System.currentTimeMillis() - start;
    }

    void showResults() {
        Collections.sort(results);
        for (Result result : results)
            System.out.printf("%-30.30s : %d\n", result.site, result.time);
        System.out.println("------------------");
    }

    public void start(String[] args) {
        Runnable showResultsAction = new Runnable() {
            @Override
            public void run() {
                showResults();
                results.clear();
            }
        };
        barrier = new CyclicBarrier(args.length, showResultsAction);

        for (final String site : args)
            new Thread() {
                public void run() {
                    while (true) {
                        long time = timeConnecton(site);
                        results.add(new Result(time, site));
                        try {
                            Integer i = barrier.await();
                            System.out.println(i);
                        } catch (BrokenBarrierException e) {
                            return;
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            }.start();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(args));
        new SiteTimer().start(args);
    }
}
