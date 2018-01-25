package instanceOf_isInstance_isAssignableFom;

//import org.openjdk.jmh.annotations.Benchmark;

class A {public Integer a = 1;}
class B extends A {public Integer a = 2;}
class C extends A {}

public class InstanceofDemo
{
//    @Benchmark
    public static void main(String args[])
    {
        A a = new A();
        B b = new B();
        C c = new C();

        A ab = new B();
        System.out.println(ab.a);
        System.out.println(((B)ab).a);

        System.out.println("a instanceof A: " + (a instanceof A)); //true
        System.out.println("b instanceof A: " + (b instanceof A)); //true
        System.out.println("c instanceof A: " + (c instanceof A)); //true
        System.out.println("a instanceof B: " + (a instanceof B)); //false
        System.out.println("null instanceof A: " + (null instanceof A)); //false

        System.out.println("a.getClass().isInstance(a): " + a.getClass().isInstance(a)); //true
        System.out.println("a.getClass().isInstance(c): " + a.getClass().isInstance(c)); //true
        System.out.println("c.getClass().isInstance(a): " + c.getClass().isInstance(a)); //false
        System.out.println("b.getClass().isInstance(c): " + b.getClass().isInstance(c)); //false

        System.out.println("a.getClass().isAssignableFrom(A.class): " + a.getClass().isAssignableFrom(A.class)); //true
        System.out.println("b.getClass().isAssignableFrom(A.class): " + a.getClass().isAssignableFrom(C.class)); //true
        System.out.println("b.getClass().isAssignableFrom(A.class): " + b.getClass().isAssignableFrom(A.class)); //false
    }
}
