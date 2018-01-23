package plays_with_multi_thread;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class Example_28_11_17 {
    private static final int
            COUNT_THREAD = 16,
            SLEEP_TIME = 1,
            ATOMIC_INTEGER = 0;
    private static final AtomicLong sequenceNumber = new AtomicLong(ATOMIC_INTEGER);
    private static ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);

    private final static Object lock = new Object();

    /**
     * - server
     * from 41677K->1197K(215552K) to
     *
     * without -server
     * from 65536K->960K(76288K)]
     */

    public static void main(String[] args) throws InterruptedException {
        String processName =
                java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
        long l = Long.parseLong(processName.split("@")[0]);
        System.out.printf("My pid = %d" + System.lineSeparator(), l);

        while (true) {
            synchronized (lock) {
                a();
                lock.wait();
            }
        }
    }

    private static void a() throws InterruptedException {
        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < COUNT_THREAD; ++i) {
                    new String("12321");
                    new String("12322");
                    new String("123441");
                    new String("12355551");
                    executorService.execute(threads());
                }

                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.notifyAll();
                }
            }
        }).start();
    }

    private static Runnable threads() {
        return () -> {
            final long currentAtomicLong = sequenceNumber.getAndIncrement();
            /*System.out.printf(
                    "My name is (%s) and current int is (%d) and time (%s)" + System.lineSeparator(),
                    Thread.currentThread().getName(),
                    currentAtomicLong,
                    LocalDateTime.now()
            );*/
        };
    }
}
