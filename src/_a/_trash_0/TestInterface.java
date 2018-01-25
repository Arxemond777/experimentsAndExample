package _a._trash_0;

import java.io.IOException;

public class TestInterface
{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Some1 some1 = Some1.class.newInstance();
    }
}

interface _A
{
    void a() throws IOException;
}

class Some1 implements _A
{
    @Override
    public void a() {

    }
}