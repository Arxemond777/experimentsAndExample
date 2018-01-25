package ExammpleWithHabr;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.LOCAL_VARIABLE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotUnderstand {
    String name() default "";
    /** Что это? */
    static final String WHAT1 = "WHAT1";
    /** А это? */
    final String WHAT2 = "WHAT2";
    /** Кто разрешил здесь класс объявить? */
    static class What3 {
    };
}
