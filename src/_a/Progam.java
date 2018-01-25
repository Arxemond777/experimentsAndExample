package _a;

public class Progam
{
    public static void main(String[] args) {
        Sub sub = new Sub();
        Base base = sub;

        System.out.println(base.name); // Если поле - то не переопределяется
    }
}

class Sub extends Base
{
    public String name = "Sub";
    public String getName() {
        return name;
    }
}

class Base
{
    public String name = "Base";
    public String getName() {
        return name;
    }
}
