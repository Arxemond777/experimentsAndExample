/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sample;

//import org.openjdk.jmh.annotations.Benchmark;
//import org.openjdk.jmh.annotations.Fork;
//import org.openjdk.jmh.annotations.BenchmarkMode;
//import org.openjdk.jmh.annotations.State;
//import org.openjdk.jmh.annotations.Scope;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

//@State(Scope.Benchmark)
public class MyBenchmark {

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

//    @Benchmark
    public void mains() throws InterruptedException {
        String processName =
                java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
        long l = Long.parseLong(processName.split("@")[0]);
//        System.out.printf("My pid = %d" + System.lineSeparator(), l);

        while (sequenceNumber.get() <= 10_000L) {
            synchronized (lock) {
                a();
                lock.wait();
            }
        }
        sequenceNumber.compareAndSet(9_000L, 9_000L);
    }

    private static void a() throws InterruptedException {
        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < COUNT_THREAD; ++i) {
                    new String("12321");
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
