package JavaConcurrencyInPractice.Ch5_BuildingBlocks_ConcurrencePackage.Efficient_Scalable_Cache_5_19;

import java.util.Objects;
import java.util.concurrent.*;

import static JavaConcurrencyInPractice.Ch5_BuildingBlocks_ConcurrencePackage.LaunderThrowable.launderThrowable;

public class Memorizer<A, V> implements Computable<A, V> {
    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memorizer(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(final A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (Objects.isNull(f)) {
                Callable<V> eval = () -> c.compute(arg);
                FutureTask<V> ft = new FutureTask<>(eval);
                f = cache.putIfAbsent(arg, ft);
                if (Objects.isNull(f)) {
                    f = ft;
                    ft.run();
                }
            }
            try {
                return f.get();
            } catch (CancellationException cs) {
                cache.remove(arg, f);
            } catch (ExecutionException ee) {
                throw launderThrowable(ee.getCause());
            }
        }
    }
}
