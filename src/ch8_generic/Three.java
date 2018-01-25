package ch8_generic;

public class Three {
    public static void main(String [] args) {
        Three t = new Three();
//        t.cache(new Date());
        Three.max(new Integer(1), new Float(2));
    }

    <T> T cache(T entry) {
        System.out.println(entry.getClass());
        return entry;
    }

    public static <T extends Number> T max (T x, T y) {
//        System.out.println(((Integer) x).compareTo(y));
        return x;
    }
}
