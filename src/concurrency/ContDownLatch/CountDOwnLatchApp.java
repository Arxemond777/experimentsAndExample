package concurrency.ContDownLatch;

import java.util.*;
import java.util.concurrent.CountDownLatch;

class Race {
    private Random rand = new Random();

    private final int MIN = 50;
    private int distance = MIN + rand.nextInt(250);
    private CountDownLatch start;
    private CountDownLatch finish;

    private List<String> horses = new ArrayList<String>();

    public Race(String... names) {
        this.horses.addAll(Arrays.asList(names));
    }

    public int getDistance() {
        return distance;
    }

    public void run()
            throws InterruptedException {
        System.out.println("And the horses are stepping up to the gate...");
        final CountDownLatch start = new CountDownLatch(1); // For start race. Need only one Barrier where all horses will be waited
        final CountDownLatch finish = new CountDownLatch(horses.size()); // This barrie will be waited till all horses arrived
        final List<String> places =
                Collections.synchronizedList(new ArrayList<String>());

        for (final String h : horses) { // For each horse
            new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println(h +
                                " stepping up to the gate...");
                        start.await(); // LABEL-1: all horse wait start LABEL-2
                        System.err.println(h + "-GO!");

                        int traveled = 0;
                        while (traveled < distance) {
                            // через 0-2 секунды....
                            Thread.sleep(rand.nextInt(3) * 1000);

                            // ... лошадь проходит дистанцию 0-14 пунктов
                            traveled += rand.nextInt(15);
                            System.out.println(h +
                                    " advanced to " + traveled + "!");
                        }
                        finish.countDown();
                        System.out.println(h +
                                " crossed the finish!");
                        places.add(h);
                    } catch (InterruptedException intEx) {
                        System.out.println("ABORTING RACE!!!");
                        intEx.printStackTrace();
                    }
                }
            }).start();
        }

        System.err.println("And... they're off!");
        start.countDown(); // LABEL-2 activate race

        finish.await();
        System.out.println("And we have our winners!");
        System.out.println(places.get(0) + " took the gold...");
        System.out.println(places.get(1) + " got the silver...");
        System.out.println("and " + places.get(2) + " took home the bronze.");
    }
}

public class CountDOwnLatchApp {
    public static void main(String[] args)
            throws InterruptedException, java.io.IOException {
        System.out.println("Prepping...");

        Race r = new Race(
                "Beverly Takes a Bath",
                "RockerHorse",
                "Phineas",
                "Ferb",
                "Tin Cup",
                "I'm Faster Than a Monkey",
                "Glue Factory Reject"
        );

        System.out.println("It's a race of " + r.getDistance() + " lengths");

        System.out.println("Press Enter to run the race....");
        System.in.read();

        r.run();
    }
}
