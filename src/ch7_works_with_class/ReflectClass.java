package ch7_works_with_class;


import java.lang.reflect.*;

public class ReflectClass {

    public static void main(String [] args) throws NoSuchMethodException {
        Method method = Object.class.getDeclaredMethod( "clone" );
        //method.setAccessible(true);
        int perm = method.getModifiers();

        System.out.println(Modifier.isPublic(perm));
        System.out.println(Modifier.isProtected(perm));
        System.out.println(Modifier.isPrivate(perm));

        ReflectClass.field();
    }

    static void field() {
        Field [] a = A.class.getDeclaredFields();
        for (Field as : a) {
            System.out.println(as.getName());
        }
    }

    class A {
        int r, b;
        private int t, y;
        protected int d, f;
        public int h, j;
    }

}
