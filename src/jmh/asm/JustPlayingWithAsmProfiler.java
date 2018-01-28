package jmh.asm;

import org.openjdk.jmh.annotations.*;

// experimentsAndExample/jmh-number-verification-performance-test/src/main/java/com/example/MyBenchmark.1_____java

/**
 * https://habrahabr.ru/post/347124/ + https://github.com/dtrace4linux/linux#introduction + https://eax.me/dtrace/
 * 1) download (make) hsdis-amd64.so
 * 2) move hsdis-amd64.so in $JAVA_HOME/jre//lib/amd64/server/
 *
 * )VMOptions -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly
 *
 * run java with hsdis-amd64.so in $JAVA_HOME/jre//lib/amd64/server/hsdis-amd64.so
 /usr/lib/jvm/jdk-8u151-linux-x64/jdk1.8.0_151/bin/java -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly \
-cp /home/glushenkov/.m2/repository/org/openjdk/jmh/jmh-core/1.20/jmh-core-1.20.jar:\
/home/glushenkov/.m2/repository/net/sf/jopt-simple/jopt-simple/4.6/jopt-simple-4.6.jar:\
/home/glushenkov/.m2/repository/org/apache/commons/commons-math3/3.2/commons-math3-3.2.jar:\
./target/classes/ \
 jmh.asm.JustPlayingWithAsmProfiler
 */

@State(Scope.Benchmark)
public class JustPlayingWithAsmProfiler {
    public static void main(String[] args) throws Exception {
        System.exit(1);
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Fork(value = 20, warmups = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    public double log(BenchmarkState x) {
        return Math.log(x.x);
    }

    @State(Scope.Benchmark)
    public static class BenchmarkState {
        volatile double x = Math.PI;
    }
}
