package _a._trash_0;

import java.util.Optional;

public class TestOptional {
    static Integer i = 1;
    static Integer J = 1;

    public static void main(String[] args) {
        ASD
                asd = new ASD(),
                asd1 = new ASD(new Inner());

        Inner2 inner2 = Optional
                .ofNullable(asd.getInner())
                .map(Inner::getInner2)
                .orElse(asd1.getInner().getInner2());

        System.out.println(inner2.getI());

//        System.out.println(asd1.getInner().getInner2());
//        System.out.println(asd.getInner().getInner2());
    }

}

class ASD {

    private Inner inner;

    ASD(Inner inner) {
        this.inner = inner;
    }

    ASD() {
    }

    public Inner getInner() {
        return inner;
    }

}

class Inner {
    private Inner2 inner2 = new Inner2();

    public Inner2 getInner2() {
        return inner2;
    }

    Integer getJ() {
        return  ++TestOptional.J;
    }
}

class Inner2 {
    Integer getI() {
        return  ++TestOptional.i;
    }

}