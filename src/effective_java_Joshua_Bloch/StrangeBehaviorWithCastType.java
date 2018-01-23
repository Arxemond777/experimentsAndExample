package effective_java_Joshua_Bloch;

import java.util.*;

public class StrangeBehaviorWithCastType {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<> ();
//        OverrideArrayList<Integer> list = new OverrideArrayList<> ();
        List<Integer> list = new ArrayList<> ();
        for (int i = -3; i < 15; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = -3; i < -1; i++) {
            set.remove(i);
//            list.remove(list.myIndexOf(i)); // TODO LEL
            list.remove(list.indexOf(i));
        }

        //System.out.println(list.subList(5, 6).indexOf(1));
        System.out.println(set);
        System.out.println(list);
    }
}
