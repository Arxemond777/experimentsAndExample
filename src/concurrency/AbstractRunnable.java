package concurrency;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractRunnable implements Runnable {
    protected final Queue<Long> queue;
    protected final AtomicLong atomicLong;
    protected final String threadName;
    protected final int delay;
    protected static final Object objectForSynchronize = new Object();

    private AbstractRunnable() {
        queue = null;
        atomicLong = null;
        threadName = null;
        delay = 0;
    }

    public AbstractRunnable(Queue<Long> queue, AtomicLong atomicLong, int delay, String threadName) {
        this.queue = queue;
        this.atomicLong = atomicLong;
        this.delay = delay;
        this.threadName = threadName;
    }
}