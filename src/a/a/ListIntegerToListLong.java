package a.a;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class ListIntegerToListLong {

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);

        Set<Long> collect = li.stream().map(Integer::longValue).collect(toSet());
    }
}
