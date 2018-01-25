package playes_with_reflections;


import java.lang.reflect.Method;

public class SunReflectionUtil
{
    private static final boolean SUN_REFLECTION_SUPPORTED;
    private static final Method GET_CALLER_CLASS;

    static {
        Method getCallerClass;
        try {
            final Class<?> sunReflectionClass = Class.forName("sun.reflect.Reflection");
            getCallerClass = sunReflectionClass.getDeclaredMethod("getCallerClass", int.class);
        } catch (final Exception e) {
            System.out.println("sun.reflect.Reflection.getCallerClass is not supported." + e);
            getCallerClass = null;
        }
        SUN_REFLECTION_SUPPORTED = getCallerClass != null;
        GET_CALLER_CLASS = getCallerClass;
    }

    public static Class<?> getCallerClass(final int index) {
        try {
            int i = 0;
            Class<?> clazz = (Class<?>) GET_CALLER_CLASS.invoke(null, i);
            while (clazz != null) {
                System.out.println("Caller class at index[" + i + "]->" + clazz.getName());
                clazz = (Class<?>) GET_CALLER_CLASS.invoke(null, ++i);
            }
        } catch (Exception e) {
            System.out.println("Exception navigating through frames");
        }

        if (index < 0) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (supportsFastReflection()) {
            try {
                return (Class<?>) GET_CALLER_CLASS.invoke(null, index + 1);
            } catch (final Exception e) {
                System.out.println("Error in ReflectionUtil.getCallerClass({}), index<" + index + ">" + ", exception< " + e + ">");
                return null;
            }
        }
        return null;
    }

    public static boolean supportsFastReflection() {
        return SUN_REFLECTION_SUPPORTED;
    }

}