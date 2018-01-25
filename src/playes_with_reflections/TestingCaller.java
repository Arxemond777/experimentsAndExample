package playes_with_reflections;

public class TestingCaller
{
    public static void main(String[] args) {

        System.out.println(new ClassContext().getCallerClass());
        System.out.println(new ClassContext(Long.class).getCallerClass());
    }
}

class ClassContext {
    private Class<?> clazz;

    public ClassContext() {
        //Подставляем нашу версию
//        clazz = Reflection.getCallerClass(2);
        clazz = SunReflectionUtil.getCallerClass(2);
    }

    public ClassContext(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getCallerClass() {
        return clazz;
    }
}