package _a;

import java.lang.reflect.InvocationTargetException;

public class GenericExample {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SomeClass<Long, String> stubSomeClass = new SomeClass<>(123L);

        System.out.println(stubSomeClass.returnOutput());
    }
}

class SomeClass<Input extends Long, Output extends String> {

    private Input input;

    SomeClass(Input input) {
        this.input = input;
    }

    @SuppressWarnings("unchecked")
    public Output returnOutput() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        return (Output) Long.toString(input);
    }

}