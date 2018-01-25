package _Thing_Java.chapter_12;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.Math;

class SomeExceptionA extends Exception
{

}

class SomeExceptionB extends IOException
{
}

interface SomeInterfaceA
{
    void a() throws SomeExceptionA;
}

abstract class SomeAbstractClassA
{
    void a() throws SomeExceptionB, SomeExceptionA {

    }
}

class SomeClassA extends SomeAbstractClassA implements SomeInterfaceA
{

    @Override
    public void a() throws SomeExceptionA {

    }

}

public class ManyDifferentThrowsWithCommonException
{
    public static void main(String[] args) throws Exception {

        Method declaredMethod = SomeClassA.class.getDeclaredMethod("a");
        Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
        for (Class<?> exception : exceptionTypes) {
            System.out.println(exception);
        }
    }
}
