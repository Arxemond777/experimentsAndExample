package java_8;

import java.util.function.Consumer;

public class PrinterExample {
    public static void main(String[] args) {
        Printer printer = new Printer();

        // 2 раза, ибо Вызов 2 раза printer.print(p -> p.print(
        printer.print(p -> p.print(new Consumer<Printer>() {
            @Override
            public void accept(Printer printer) {
                ArticleWork articleWork = new ArticleWork("Java1");
                System.out.println(articleWork.layers());
            }
        }));

        // ХЗ, как делать
        //printer.print(p -> new ArticleWork("Java1").getAllArticles().forEach(p::print));
    }
}

class Printer implements Consumer {

    private final Printer printer;

    public Printer() {
        printer = this;
//        printer = new Printer(); // А так рекурсивное создание себя
    }

    private void prepare() {
        System.out.println("On");
    }

    private void sleep() {
        System.out.println("off");
    }

    public void print(Consumer<Printer> toPrint) {
        printer.prepare();
        toPrint.accept(printer);
        printer.sleep();
    }

    @Override
    public void accept(Object o) {
    }
}