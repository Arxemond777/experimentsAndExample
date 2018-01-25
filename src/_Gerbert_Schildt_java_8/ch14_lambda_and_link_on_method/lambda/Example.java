package _Gerbert_Schildt_java_8.ch14_lambda_and_link_on_method.lambda;

public class Example
{

    @FunctionalInterface
    interface MyVal
    {
        double getValue(double d);
    }

    static void page507() {
        MyVal myVal = null;
        myVal = (double d) -> d * 98.4;
        System.out.println(myVal.getValue(2));
        myVal = (d) -> d + 3; // без типа с другой реализацией функциональности
        System.out.println(myVal.getValue(2));
        //myVal = (d) -> "S"; // не соответствует возвращаемому типу
    }

    @FunctionalInterface
    interface StringTest
    {
        boolean test (String string, String string1);
    }

    static void page512() {
        StringTest stringTest = null;
        stringTest = (s, s1) -> s.indexOf(s1) != -1;

        /**
         * В отличие от
         *  "text text".equals("text") // false
         *  "text text".contains("text") // true
         */
        stringTest = (s, s1) -> s.contains(s1);
        stringTest = String::contains;

        System.out.println(stringTest.test("abc", "b"));
    }

    @FunctionalInterface
    interface withException
    {
        String exception() throws Exception;
    }

    static void page513() throws Exception {
        withException a = () -> {

            if (Math.random() == 1)
                return "a";
            else
                throw new Exception("1");
        };

        a.exception();
    }

    @FunctionalInterface
    interface GeneralizedInterface<T>
    {
        T test(T t, T t1);
    }

    static void page514() {
        GeneralizedInterface<String> generalizedInterface = (s, s1) -> s + " / " + s1;
        String s = generalizedInterface.test("Hello", "world");
        System.out.println(s);
    }

    @FunctionalInterface
    interface СaptureVariable
    {
        int func(int i);
    }

    static void page521() {
        int a = 12;
        СaptureVariable сaptureVariable = i -> {
            System.out.println(i + a); //ЧИтать можно

            //a++; // А вот менять нелья

            return a;
        };

        System.out.println(сaptureVariable.func(4));
    }

    public static void main(String[] args) throws Exception {
//        Example.page507(); // Простой пример
//        Example.page512(); // Проверка строки в подстроке
//        Example.page513(); // С Exception
        Example.page514(); // С обощенным интерфейсом
//        Example.page521(); // Захват переменной
    }
}
