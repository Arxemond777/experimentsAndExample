package ExammpleWithHabr;

public class InnerClassCreate
{
    public static void main(String[] args) {
        InnerClassExample.InnerClass.InnerInnerClass innerInnerClass = new InnerClassExample().new InnerClass().new InnerInnerClass();
    }
}
