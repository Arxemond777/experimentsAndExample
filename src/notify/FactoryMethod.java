package notify;

public class FactoryMethod
{
    public static void main(String[] args) {
        CreatorFactory creatorFactory = new CreatorFactory();
        creatorFactory.create();
    }
}

class CreatorFactory
{
    public void create() {
        Aa[] a = {new Bb(), new Cc()};

        for(Aa someClass : a)
            someClass.someMethod();
    }
}

interface Aa
{
    void someMethod();
}

class Bb implements Aa
{
    @Override
    public void someMethod() {
        System.out.println(this.getClass().getSimpleName());
    }
}

class Cc implements Aa
{
    @Override
    public void someMethod() {
        System.out.println(this.getClass().getSimpleName());
    }
}