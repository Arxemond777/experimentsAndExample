package ch11_main_tools;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.lang.System;

public class PropertiesAPI
{
    public static void main(String[] args) throws FileNotFoundException, IOException {
        List l = new ArrayList();
        List syncList = Collections.synchronizedList(l);

        Properties defaults = new Properties();
        defaults.setProperty("X.Y", "1:2");
        Properties properties = new Properties(defaults);
        properties.setProperty("TestPropertu.xsize", "52");
        properties.setProperty("dwbbdf", "524");
//        properties.setProperty("X.Y", "1:2");


        System.out.println(properties.get("TestPropertu.xsize"));
        System.out.println(properties.get("TestPropertu.xsize123"));
        System.out.println(properties.getProperty("X.Y"));
        System.out.println(properties.getProperty("Undefined", "Default Value"));
        System.out.println("______________________________");
        properties.save(System.out, "Application Parameters");
        properties.storeToXML(new FileOutputStream("ApplicationParameters.xml"), "Application Parameters");
        properties.save(new FileOutputStream("ApplicationParameters.txt"), "Application Parameters");
        System.out.println("______________________________");

        //System.setProperty()//установка собственных СИСТЕМНЫХ СВОЙСТВ
        //из консоли java -Dfoo=cat -Dcat=r MyApp
        //Integer.getInteger("Foo")//Ищет системное слово Foo и возвращает Integer
        System.out.println(System.getProperty("os.arch"));
    }

}

class MyObject1
{

}

interface A
{
    static void f() {
    }

    default void D() {

    }
}