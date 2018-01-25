package playes_with_reflections;

public class SunReflectionExample
{
    public static void main(String[] args) throws Exception {
        ClassContext classContext = new ClassContext();
        System.out.println(classContext.getCallerClass().getName());
    }
}
