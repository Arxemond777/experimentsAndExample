import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class DefaultInterface
{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        SimpleCLass simpleCLass = SimpleCLass.class.newInstance();
        simpleCLass.a();
        System.out.println(Arrays.toString(SimpleCLass.class.getInterfaces()));
        simpleCLass.b();
    }
}

//http://docs.oracle.com/javase/1.5.0/docs/guide/language/annotations.html
//http://docs.oracle.com/javase/tutorial/java/annotations/declaring.html
@RequestForEnhancement(id = 1, synopsis = "2")
class SimpleCLass implements Aa //Но Bb нельзя без переобъявления
{
    void b() {
        System.out.println(RequestForEnhancement.class.getAnnotatedInterfaces());
    }
}

interface Aa
{
    default void a() {
        System.out.println(this.getClass().getSimpleName());
    }
}

interface Bb
{
    default void a() {
        System.out.println(this.getClass().getSimpleName());
    }
}


//https://habrahabr.ru/post/139736/ - про @interface и еще несколько интересных онатаций
@Retention(value= RetentionPolicy.RUNTIME) // позволяет указать жизненный цикл аннотации: будет она присутствовать только в исходном коде, в скомпилированном файле, или она будет также видна и в процессе выполнения.
@interface RequestForEnhancement {
    int    id();
    String synopsis();
    String engineer() default "[unassigned]";
    String date()    default "[unimplemented]";
}