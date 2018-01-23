package blosh.chapter_6_enum_and_annotations.enum_set_32;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

public class example {
    public static void main(String[] args) {
        Test.apply(Test.D & Test.C);
        Test.apply(Test.D & Test.D);
        Test.apply(Test.B | Test.C);
        System.out.println(Test.A);
        System.out.println(Test.B);
        System.out.println(Test.C);
        System.out.println(Test.D);

        Test.apply(Test.A | Test.C);
        TestEnumSet.apply(EnumSet.of(TestEnumSet.Style.A, TestEnumSet.Style.C));
    }
}

class Test {
    public static final int A = 1 << 0;
    public static final int B = 1 << 1;
    public static final int C = 1 << 2;
    public static final int D = 1 << 3;

    public static void apply(int someInt) {
        System.out.printf("My name: %s. My value: %d" + System.lineSeparator(), Test.class, someInt);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

class TestEnumSet {
    enum Style {
        A(1 << 0), B(1 << 1), C(1 << 2), D(1 << 3);

        private int i;

        Style(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }
    }
    public static void apply(Set<Style> someInt) {
        System.out.printf("My name: %s. ", TestEnumSet.class);
        //System.out.print(someInt.add(Style.B));
        int i = 0;
        for (Style aSomeInt : someInt) {
            i |= aSomeInt.getI();
        }
        System.out.printf("My value: %d" + System.lineSeparator(), i);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}