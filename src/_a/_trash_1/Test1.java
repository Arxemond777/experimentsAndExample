package _a._trash_1;

public class Test1 {
    public static void main(String[] args) {
        Tt_1
                tt_1 = new Tt_1(),
                tt_2 = new Tt_1();

        System.out.println(tt_1.c(tt_2));
        System.out.println(tt_1.c(tt_1));
    }
}

class Tt_1 {
    boolean c(Tt_1 tt_1) {
        return this == tt_1;
    }
}
