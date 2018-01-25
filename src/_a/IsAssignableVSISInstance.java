package _a;

public class IsAssignableVSISInstance
{
    public static void main(String[] args) {
        Class a_ = new A_().getClass();
        Class b_ = B_.class;

        System.out.println(a_.isAssignableFrom(b_)); // Является ли b_ - проверяемая
        System.out.println(a_.isInstance(b_));

        System.out.println("________0__________");

        System.out.println(b_.isAssignableFrom(a_)); // Является ли a_ - проверяемая
        System.out.println(b_.isInstance(a_));

        System.out.println("________1__________");

        System.out.println(b_.isAssignableFrom(b_));
        System.out.println(b_.isInstance(b_));

        System.out.println("________2__________");

        System.out.println(a_.isAssignableFrom(a_));
        System.out.println(a_.isInstance(a_));
    }
}

class A_
{

}

class B_ extends A_
{

}