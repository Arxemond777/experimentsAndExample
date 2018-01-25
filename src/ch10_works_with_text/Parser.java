package ch10_works_with_text;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static void main(String[] args) {
        String s = "Foo, bar, baz";
        String [] f = s.split(",");
        String [] f1 = s.split("\\s*,\\s*");

        System.out.println(Arrays.toString(f));
        System.out.println(f[0]);
        System.out.println(Arrays.toString(f1));

        String number = "Tel: 123-45-6789.";
        Matcher matcher = Pattern.compile("\\d\\d\\d-\\d\\d-(\\d\\d\\d\\d)").matcher(number);
//        while (matcher.find())
//            System.out.println(matcher.group());
        String output = matcher.replaceAll("XXX-XX-$1");
        System.out.println(output);


        try { //File get contents
            InputStream source = new URL("http://oreilly.com/").openStream();
            String text = new Scanner(source).useDelimiter("\\A").next();
            //System.out.println(text);
        } catch (MalformedURLException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
