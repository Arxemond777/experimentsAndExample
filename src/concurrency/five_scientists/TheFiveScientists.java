package concurrency.five_scientists;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TheFiveScientists {
    enum EScientist {
        FIRST(new Scientist(new Fork(InnerFork.FORK_ONE.getForkName()), new Fork(InnerFork.FORK_TWO.getForkName())), "Thread-scientistOne"),
        SECOND(new Scientist(new Fork(InnerFork.FORK_TWO.getForkName()), new Fork(InnerFork.FORK_THREE.getForkName())), "Thread-scientistTwo"),
        THIRD(new Scientist(new Fork(InnerFork.FORK_THREE.getForkName()), new Fork(InnerFork.FORK_FOUR.getForkName())), "Thread-scientistThree"),
        FORTH(new Scientist(new Fork(InnerFork.FORK_FOUR.getForkName()), new Fork(InnerFork.FORK_FIVE.getForkName())), "Thread-scientistFour"),
        FIFTH(new Scientist(new Fork(InnerFork.FORK_FIVE.getForkName()), new Fork(InnerFork.FORK_ONE.getForkName())), "Thread-scientistFive");

        public Scientist getScientist() {
            return scientist;
        }

        private enum InnerFork {
            FORK_ONE("forkOne"),
            FORK_TWO("forkTwo"),
            FORK_THREE("forkThree"),
            FORK_FOUR("forkFour"),
            FORK_FIVE("forkFive");

            private String forkName;

            InnerFork(String forkName) {
                this.forkName = forkName;
            }

            public String getForkName() {
                return forkName;
            }
        }

        private final String name;
        private final Scientist scientist;

        EScientist(Scientist scientist, String name) {
            this.scientist = scientist;
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static Thread getScientist(EScientist eScientist) { // method reference in the static context
        return new Thread(eScientist.getScientist(), eScientist.getName());
    }
    public static void main(String[] args) throws InterruptedException {
        Stream.of(EScientist.values())
                .map(TheFiveScientists::getScientist)
                .collect(Collectors.toList())
                .forEach(Thread::start);

        while (true) {
            System.out.printf(
                    "1 | %d" + System.lineSeparator() +
                    "2 | %d" + System.lineSeparator() +
                    "3 | %d" + System.lineSeparator() +
                    "4 | %d" + System.lineSeparator() +
                    "5 | %d" + System.lineSeparator(),
                    EScientist.FIRST.getScientist().getCurrentEat(),
                    EScientist.SECOND.getScientist().getCurrentEat(),
                    EScientist.THIRD.getScientist().getCurrentEat(),
                    EScientist.FORTH.getScientist().getCurrentEat(),
                    EScientist.FIFTH.getScientist().getCurrentEat()
            );
            TimeUnit.SECONDS.sleep(3);
        }

        //new PlayWithStaticReferenceForTheFiveScientists().exec();
    }
}

class Fork {
    Lock lock = new ReentrantLock(true);
    private final String nameFork;

    Fork(String nameFork) {
        this.nameFork = nameFork;
    }

    public String getNameFork() {
        return nameFork;
    }
}

class Scientist implements Runnable {

    private final Fork leftFork;
    private final Fork rightFork;
    private AtomicLong currentEat = new AtomicLong();

    public Scientist(Fork leftFork, Fork rightFork) {
        Objects.requireNonNull(leftFork, () -> "required left fork");
        Objects.requireNonNull(rightFork, () -> "required right fork");

        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        while (true) {
            leftFork.lock.lock();
            rightFork.lock.lock();
            long peaceOfEat = currentEat.incrementAndGet();
            /*System.out.printf("nameThread = %s {left: %s|right: %s}, eat = %d" + System.lineSeparator(),
                    Thread.currentThread().getName(),
                    leftFork.getNameFork(),
                    rightFork.getNameFork(),
                    peaceOfEat);*/
            leftFork.lock.unlock();
            rightFork.lock.unlock();

            try {
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    long getCurrentEat() {
        return this.currentEat.get();
    }
}