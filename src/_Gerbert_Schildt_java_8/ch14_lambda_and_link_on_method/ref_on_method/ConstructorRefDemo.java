package _Gerbert_Schildt_java_8.ch14_lambda_and_link_on_method.ref_on_method;

@FunctionalInterface
interface MyFucn {
    MyClass func(String s);
}

class MyClass {
    String s;

    MyClass() {
        this.s = "";
    }

    MyClass(String s) {
        this.s = s;
    }

    String getS() {
        return this.s;
    }
}

public class ConstructorRefDemo
{
    public static void main(String[] args) {
        MyFucn myFucn = MyClass::new;

        MyClass myClass = myFucn.func("Test");

        System.out.println(myClass.getS());
    }
}
