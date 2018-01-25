package ch10_works_with_text;

public class Formatter {
    public static void main(String[] args) {
        String s = String.format("Меня зовут %s и мне %d лет", "Юра", Integer.valueOf("12"));
        System.out.println(s);

        System.out.printf("%5s", "ab\n");//дополняется пробелами до нужной длины
        System.out.printf("%.5s", "abцацуашуциа");//обрезается за счет буквенного значения символа "."
        System.out.printf("\n");
        //similar
        System.out.printf("%.5s", "a");//не добавляет пробелы
        System.out.printf("\n");
        System.out.printf("%-5s", "a");//не добавляет пробелы, рекомендуют этот способ

        //

        String [] words = new String[] {"World", "Length", "joifriufbuhchjbdshfgregfuyvr"};
        System.out.printf("%-10s %s\n", "World", "Length");

        for (String word : words)//Пример с форматированием и обрезкой до нужной длины
            System.out.printf("%-10.10s %s\n", word, word.length());

        /** Использование одного аргумента несколько раз и приведения к заглавному виду аргументов форматирвоания */
        System.out.printf("А %2$S - это %2$s и вовсе не %1$s\n", "огурец", "роза");

        /** Символ преобразования %с производит символы Unicode*/
        System.out.printf("Первая буква %c\n", 'a');

        /** Вывод логического значения своих аргументов */
        System.out.printf("The door is open: %b\n", door.open() == true);

        System.out.printf("float is %f\n", 1.23456789);//по умолчанию 6, после точки с запятой
        System.out.printf("float is %.3f\n", 1.23456789);
        System.out.printf("float is %.1f\n", 1.23456789);
        System.out.printf("float is %.0f\n", 1.23456789);

//        Нельзя static в внутренних классах
//        В подклассе можно переопределить метод с private->public, но не наоборот
//        class door {
//            static boolean open() {return  true;}
//        }
    }
}

class door {
    static boolean open() {return  true;}
}
