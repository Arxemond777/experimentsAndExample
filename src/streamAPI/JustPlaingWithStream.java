package streamAPI;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class JustPlaingWithStream {
    public static void main(String[] args) {
        Person p1, p2, p3, p4;
        p1 = new Person();
        p2 = new Person();
        p3 = new Person();
        p4 = new Person();
        p1.setName("A");
        p1.setSum(BigDecimal.valueOf(1));

        p2.setName("B");
        p2.setSum(BigDecimal.valueOf(2));

        p3.setName("A");
        p3.setSum(BigDecimal.valueOf(3));

        p4.setName("C");
        p4.setSum(BigDecimal.valueOf(4));

        List<Person> personList = Arrays.asList(p1, p2, p3, p4);

        System.out.println(getMap(personList));
    }

    public static Map<String, List<BigDecimal>> getMap(List<Person> strings) {
        return strings.stream().collect(
                Collectors.groupingBy(Person::getName, Collectors.mapping(Person::getSum, Collectors.toList()))
        );
    }
}

class Person {
    private String name;
    private BigDecimal sum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
