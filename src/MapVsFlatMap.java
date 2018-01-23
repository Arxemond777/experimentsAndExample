import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMap {
    public static void main(String[] args) {
        List<Integer>
                list1 = new ArrayList<Integer>(){{add(1); add(2);}},
                list2 = new ArrayList<Integer>(){{add(3); add(4); add(8);}};

        List<Integer> collectMap = list1.stream().map(s -> s << 1).collect(Collectors.toList());
        System.out.println(collectMap);

        List<Integer> collectFlatMap = Stream.of(list1, list2)
                .flatMap(
                        int1 -> int1.stream()
                                .map(int2 -> int2 >> 2)
                                .peek(System.out::println)
                )
                .collect(Collectors.toList());
    }
}
