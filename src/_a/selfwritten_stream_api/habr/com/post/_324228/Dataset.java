package _a.selfwritten_stream_api.habr.com.post._324228;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Dataset<T> {

    private final GeneratorFunction<T> generator;

    private Dataset(GeneratorFunction<T> generator) {
        System.out.println("_______");
        System.out.println("init");
        System.out.println("_______");
        this.generator = generator;
    }

    public void forEach(Consumer<T> consumer) {
        generator.generate(value -> consumer.accept(value));
    }

    public static <T> Dataset<T> of(Collection<T> collection) {
        return new Dataset<>(generatorContextFunction ->
                collection.forEach(item -> generatorContextFunction.emit(item))
        );
    }

    public Dataset<T> union(Collection<T> collection) {
        return new Dataset<>(generatorContext -> {
            generator.generate(generatorContext);
            collection.forEach(item -> generatorContext.emit(item));
        });
    }

    public Dataset<T> filter(Predicate<T> predicate) {
        return new Dataset<>(generatorContext -> generator.generate(value -> {
            if (predicate.test(value)) {
                generatorContext.emit(value);
            }
        }));
    }

    public <R> Dataset<R> map(Function<T, R> function) {
        return new Dataset<>(generatorContext -> generator.generate(
                value -> generatorContext.emit(function.apply(value))
        ));
    }
}
