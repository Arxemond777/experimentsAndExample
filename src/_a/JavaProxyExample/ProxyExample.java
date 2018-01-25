package _a.JavaProxyExample;

import java.lang.reflect.Proxy;

public class ProxyExample
{
    public static void main(String[] args) {
        Person person = new Person();

        System.out.println(Person.class.getClassLoader());

        IPerson personproxy = (IPerson) Proxy.newProxyInstance(
                Person.class.getClassLoader(),
                Person.class.getInterfaces(),
                new NeverSleepingEye(person)
        );

        personproxy.setName("Гриша");
        String h  = personproxy.getName() ;
        personproxy.rename("Вася");
    }
}
