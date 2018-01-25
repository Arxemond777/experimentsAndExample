package java_8.stream_map_flatmap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
        List<Integer> i  = Stream
                .of("1", "2", "3")
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        System.out.println(i);

        List<Integer> i1 = Arrays.asList(1, 2);
        List<Integer> i2 = Arrays.asList(1, 2);

        List<Integer> i3 = Stream
                .of(i1, i2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(i3);


        List<Developer> team = new ArrayList<>();
        Developer polyglot = new Developer("esoteric");
        polyglot.add("clojure");
        polyglot.add("scala");

        Developer busy = new Developer("pragmatic");
        busy.add("java");
        busy.add("javascript");

        team.add(polyglot);
        team.add(busy);

        List<String> teamLanguages = team.stream().
                //map(d -> d.getLanguages()).
                flatMap(l -> l.getLanguages().stream()).
                collect(Collectors.toList());

        System.out.println(teamLanguages);
    }
}

class Developer {

    private String name;
    private Set<String> languages;

    public Developer(String name) {
        this.languages = new HashSet<>();
        this.name = name;
    }

    public void add(String language) {
        this.languages.add(language);
    }

    public Set<String> getLanguages() {
        return languages;
    }
}
