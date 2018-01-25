package _Gerbert_Schildt_java_8.other_trash;

/**
 * -verbose:gc -XX:+PrintGCTimeStamps
 */
public class FinalizeTest
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        SomeObject someObject = SomeObject.class.newInstance();
        System.out.println(someObject.SayHi());
        someObject = null;

        System.gc();
    }
}

class SomeObject
{
    public String SayHi() {
        return "Hi!";
    }

    @Override
    protected void finalize() {
        System.out.println("I`m destroyed...");
    }
}
