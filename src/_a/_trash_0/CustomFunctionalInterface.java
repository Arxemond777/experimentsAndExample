package _a._trash_0;

public class CustomFunctionalInterface {
    public static void main(String[] args) {
        CustomFunctionalInterface customFunctionalInterface = new CustomFunctionalInterface();
        customFunctionalInterface.a(() -> {
            System.out.println(5555);
        });
    }

    void a(Aaaa a) {
        if (1 == 1)
            a.invoke();
    }
}

@FunctionalInterface
interface Aaaa {
    void invoke();
}
