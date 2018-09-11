package _a._trash_0;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class MergeTwoArrays {
    private static List aList = Collections.singletonList(1);
    private static List bList = Arrays.asList("bbb", 2L);

    public static void main(String[] args) {
        System.out.println(a());
        System.out.println(b());
    }

    static Map<Class<?>, ?> b() {

        return listsToMap(InnerEnum.B.types, bList);
    }

    static Map<Class<?>, ?> a() {

        return listsToMap(InnerEnum.A.types, aList);
    }

    private static Map<Class<?>, ?> listsToMap(List<Class<?>> keys, List<?> values) {
        if (keys.size() != values.size())
            throw new IllegalArgumentException("The lists values and keys have another size");

        return IntStream.range(0, keys.size())
                .boxed()
                .collect(toMap(keys::get, values::get));
    }
}

enum InnerEnum {
    A("A", Integer .class),
    B("B", String.class, Long .class);

    InnerEnum(String nameEnum, Class <?> ...types) {
        this.nameEnum = nameEnum;
        this.types = Arrays.asList(types);
    }

    String nameEnum;

    public List<Class<?>> getTypes() {
        return types;
    }

    List<Class<?>> types;
}