package ch7_works_with_class;

import java.lang.reflect.*;
import java.util.*;

public class StringList extends ArrayList<String> {
    public static void main(String [] args) {
        Type type = StringList.class.getGenericSuperclass();
        System.out.println(type);

        ParameterizedType pt = (ParameterizedType)type;

        System.out.println(pt.getActualTypeArguments()[0]);

        InvocationHandler ih = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object [] args) {
                System.out.println(
                    "Method: {[QOUTE-REPLACEMENT]}" + method.getName() + " () "
                    + " of interface: interfaceName invoked on proxy"
                );
                return null;
            };

            //Class clas = Class.forName(MyInterface);
            /*@Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }*/
        };
    }

}
