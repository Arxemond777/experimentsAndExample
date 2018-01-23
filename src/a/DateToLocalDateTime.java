package a;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class DateToLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();


        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formatDateTime = localDateTime.format(formatter1);

        System.out.println(formatDateTime.toString());
        System.exit(0);


        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDate ld = LocalDate.parse("2017-11-01T00:00", DATEFORMATTER);
        LocalDateTime ldt1 = LocalDateTime.of(ld, LocalDateTime.now().toLocalTime());

        System.out.println(ldt1);
        System.exit(0);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date date = formatter.parse("01.11.2017");

            LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
            String str = ldt.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru"));

            System.out.println(str);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        //System.out.println(new Date("01.11.2017"));
        System.exit(0);

        LocalDateTime ldt = LocalDateTime.ofInstant(new Date("01.11.2017").toInstant(), ZoneId.systemDefault());
        String str = ldt.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru"));

        System.out.println(str);
    }
}
