package effective_java_Joshua_Bloch;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RightImmutableObject {
    public static void main(String[] args) throws InterruptedException {
        Date d = new Date();
        Test test = new Test();
        test.setD(d);
        System.err.println(test.getD());
        d.setTime(12321L);
        System.err.println("Error!");
        System.err.println(test.getD());
        test.getD().setTime(1L);
        System.err.println("Just as error!");
        System.err.println(test.getD());

        TimeUnit.MICROSECONDS.sleep(100); // for synchronize System err&out stream

        Date d1 = new Date();
        TestRightImmutable testRightImmutable = new TestRightImmutable();
        testRightImmutable.setD(d1);
        System.out.println(testRightImmutable.getD());
        d1.setTime(12321L);
        System.out.println("Right!");
        System.out.println(testRightImmutable.getD());
        testRightImmutable.getD().setTime(12321);
        System.out.println("Just as surely!");
        System.out.println(testRightImmutable.getD());

    }
}

class Test {
    private Date d;

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }
}

class TestRightImmutable {
    private Date d;

    public Date getD() {
        return (Date) d.clone(); // TODO
    }

    public void setD(Date d) {
        this.d = new Date(d.getTime()); // TODO
    }
}