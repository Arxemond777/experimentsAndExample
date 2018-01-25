package _Gerbert_Schildt_java_8.ch13_generic;

public class ExampleGenericMethodConstructAndInterface
{
    public static void main(String[] args) {
        ExampleConstruct exampleConstruct = new ExampleConstruct(4.0F);
        System.out.println(exampleConstruct.getNumber());

        ExampleMethod exampleMethod = new ExampleMethod();
        System.out.println(exampleMethod.someMethod(1));
    }
}

class ExampleConstruct
{
    private Number number;

    <T extends Number> ExampleConstruct(T num) {
        this.number = num;
    }

    Number getNumber() {
        return number;
    }
}

class ExampleMethod
{
    public <T> T someMethod(T t) {
        System.out.println(t.getClass().getName());
        return t;
    }
}

interface Interface<T extends Number>
{

}

/** TODO */
class SomeClassImplementsInterface<T extends Number> implements Interface<T> {

}