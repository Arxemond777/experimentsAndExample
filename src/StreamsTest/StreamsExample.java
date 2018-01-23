package StreamsTest;

import javafx.util.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {
    public static void main(String[] args) {

        Pair<Integer, String> pair = new Pair<>(new Integer(1), new String("2"));
        System.out.println(pair.getKey());
        System.out.println(pair.getValue().getClass().getSimpleName());


        // Создание стрима из строки
        String str = "Foo bar baz";
//        str.chars().forEach(c -> System.out.println((char) c));
//        str.chars().parallel().forEach(c -> System.out.println((char) c));

        // Fat & flatMap Difficult
        Collection<String> collection = Arrays.asList("a,1", "a,2", "a,3");
        List<String> map = collection.stream().map((s) -> s + "_1").collect(Collectors.toList());
//        System.out.println(map);
//
        String[] flatMap = collection.stream().flatMap((p) -> Arrays.asList(p.split(",")).stream()).toArray(String[]::new);
        System.out.println(Arrays.toString(flatMap));System.exit(0);

        // Lines
        try {
            Stream<String> streamFromFiles = Files.lines(Paths.get("Examples.iml"));
//            streamFromFiles.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Stream method .collect() - из одной коллекции в другую
        Collection<SportsCamp> sport = Arrays.asList(
                new SportsCamp("Ivan", 5),
                new SportsCamp( null, 15),
                new SportsCamp("Petr", 7),
                new SportsCamp("Ira", 10)
        );
        // Отфильтровываем
        List<SportsCamp> onlyI = sport.stream().filter(p -> p.getName() != null &&  p.getName().startsWith("I")).collect(Collectors.toList());
//        System.out.println("SIZE="+onlyI.size());

        // List to Map – Collectors.toMap()
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(5, "mkyong.com", 1));


        // key = id, value - websites
        Map<String, ? extends Number> result1 = list.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites));
        System.out.println("Result 1 : " + result1);

        // Same with result1, just different syntax
        // key = id, value = name
        Map<String, ? extends Number> result3 = list.stream().collect(Collectors.toMap(x -> x.getName(), x -> x.getWebsites()));
        System.out.println("Result 3 : " + result3);

        // TODO Duplicate

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(new Hosting(3, "linode.com", 10000));

        Map<String, ? extends Number> result2;
        try {
            result2 = list.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Тут дубликейт");
        }

        /**
         * Исправленная версия
         */
        result2 = list.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites, (oldValue, newValue) -> oldValue));
        System.out.println(result2);
        result2 = list.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites, (oldValue, newValue) -> newValue));
        System.out.println(result2);

        // Reduce - Агрегируем значение
        Integer daySum = sport.stream().reduce(0, (sum, p) -> sum += p.getDay(), (sum1, sum2) -> sum1 + sum2);
//        System.out.println("DaySize=" + daySum);

    }
}

class SportsCamp {
    private  String name; //Имя спортсмена
    private  Integer day; //Количество дней в спортивном лагере

    public SportsCamp(String name, int day) {

        this.name = name;
        this.day = day;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getDay() {
        return day;
    }
    public void setDay(Integer day) {
        this.day = day;
    }
}

class Hosting {

    private int Id;
    private String name;
    private long websites;

    public Hosting(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWebsites() {
        return websites;
    }

    public void setWebsites(long websites) {
        this.websites = websites;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

}