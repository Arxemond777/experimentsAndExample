package opcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class B111 {
//    static {
//        System.out.println(1);
//    }
    static class bb222 {}

    public static void main(String[] args) throws InterruptedException {

        List<B111.bb222> l = new ArrayList<>();
        boolean b = true;
//        B111 b111 = new B111();
        while (b) {
            l.add(new B111.bb222());
//            l.add(b111.new bb222());

            MILLISECONDS.sleep(1200);
        }
        System.out.println(l);
    }
}
