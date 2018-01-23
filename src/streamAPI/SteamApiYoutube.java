package streamAPI;

import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SteamApiYoutube {
    public static void main(String[] args) {
        IntStream i = new Random().ints(1, 20 + 1)/*.parallel()*/.distinct().limit(1000005);
        //i.forEach(System.out::println);

        int[] iArr = {5, 4, 3, -1, 2, 1};
        Stream.iterate(0, ii -> iArr[ii])
                .skip(1)
                .limit(iArr.length);
//                .forEach(System.out::println);

        //Perfomrance
        // Короткое замыкание flatMap например, берется целиком в память весь источник, аде если 1 ГБ
        // но быстрее и гарантирует закрытие ресурса - ДАЖЕ ФАЙЛА и всех вложенных стримов и открытых там ресурсов (файлов)

        //////
        /**
         * с вложенными стримами (findAny например) идет tryAdvantage(hashNext+next) bp splititerator (itrerator на стероидах), который оч медленен в
         * коротких замыканиях (flatMap), в отличие от не вложенных (count) которые используют foreach-remaining - быстрый в кототких замыканиях
         */
        //.flatMap(x -> IntStream.range(0, x)) намного дольше, т.к. короткое замыкание не работает с вложенными стримами
        // при поиске 99 среди 100 короткое замыкание будет последовательно перебирать и долго в отличие от поиска 1 в 100
        // в коде ниже короткое замыкание не сработает
        Optional<Integer> int1 = IntStream.of(100_001).flatMap(x -> IntStream.range(0, x)).boxed().filter(x -> x == 100_000).findAny(); // оч медленно
        // А тут сработает
        Optional<Integer> int1_1 = IntStream.of(100_001).boxed().filter(x -> x == 100_000).findAny(); // оч быстро

        //////

        // а тут быстрее, тк count не является вложенным стримом, а findAny является
        Long int2 = IntStream.of(100_001).flatMap(x -> IntStream.range(0, x)).boxed().filter(x -> x == 100_000).count();

        /////

        System.out.println(int1.orElse(100_500));
        System.out.println(int1_1.orElse(100_500));
        System.out.println(int2);
    }
}
