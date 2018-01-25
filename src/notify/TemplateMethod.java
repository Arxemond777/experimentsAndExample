package notify;

enum Type {B, C}

public class TemplateMethod
{
    public static void main(String[] args) {
        TemplateMethodRealisation tmr = new TemplateMethodRealisation();

        try {
            A a = tmr.init(Type.B, 666);
            System.out.println(a.someAlgorithm());

            A a1 = tmr.init(Type.C, 4);
            System.out.println(a1.someAlgorithm());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TemplateMethodRealisation
{
    public A init(Type type, int integer) throws Exception {
        A a;

        switch (type) {
            case C:
                a = new C(integer);
                break;
            case B:
                a = new B(integer);
                break;
            default:
                throw new Exception("Need concrete realisation class: " + type.toString());
        }

        return a;
    }
}

abstract class A
{
    public int num;

    public A(int num) {
        this.num = num;
    }

    protected abstract int someNum();

    protected int someAlgorithm() {
        return this.num >> 1;
    }
}

class B extends A
{

    public B(int num) {
        super(num);
    }

    @Override
    protected int someNum() {
        return 0;
    }
}

class C extends A
{

    public C(int num) {
        super(num);
    }

    @Override
    protected int someNum() {
        return 0;
    }

    @Override
    public int someAlgorithm() {
        return this.num * 2;
    }
}