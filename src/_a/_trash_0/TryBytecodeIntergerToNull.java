package _a._trash_0;

public class TryBytecodeIntergerToNull {
    public static void main(String[] args) {
        TestUtil<Integer> integerTestUtil = new TestUtil<>();

        integerTestUtil.a((Integer) null);

        integerTestUtil.a((Integer) 2);

        integerTestUtil.a( null);
    }
}

class TestUtil<R> {
    void a(R r) {

    }
}
