package _Gerbert_Schildt_java_8.ch13_generic;

public class ExampleWildcartAndInheritGeneric
{
    static void test(Gen<? extends A> gen) {
        System.out.println(gen.ob); //Взяли инстанцированный параметр c классом в Gen - ob
        gen.ob.d(); //И ебашим че хотим. Ибо гарантия, что есть такой метод через <? extends A>
    }

    public static void main(String[] args) {
        B b = new B();

        Gen<B> genB = new Gen<>(b);
        System.out.println(genB.toString());
        test(genB);
    }

}

abstract class A
{
    abstract protected void d();
}

class B extends A
{

    @Override
    public void d() {
        System.out.println(1);
    }

    @Override
    public String toString() {
        return Integer.toString(123);
    }
}

//Аналог гарантии <? extends A> в Example.test
class Gen<T /*extends A*/>
{
    T ob;

    Gen(T o) {
        ob = o;
    }
}