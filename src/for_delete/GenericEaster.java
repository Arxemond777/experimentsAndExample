package for_delete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//javac -d out/production/examples/ src/for_delete/GenericEaster.java; javap -c -cp out/production/examples/ for_delete.GenericEaster
public class GenericEaster<T> {
    List<T> b(List<T> list4) {
        return list4;
    }

    public void c(T t) {
    }

    /*Object c(Object t) {
        return t;
    }*/

    public static void main(String[] args) {
        GenericEaster<Integer> genericEaster = new GenericEaster<>();
        genericEaster.c(1);
        genericEaster.b(Arrays.asList(1, 2));
    }
}
