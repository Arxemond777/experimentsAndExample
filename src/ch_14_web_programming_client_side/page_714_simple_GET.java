package ch_14_web_programming_client_side;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class page_714_simple_GET
{
    public static void main(String[] args) {
        try {
            URL url = new URL(
                    //Этот URL-адрес должен быть закодирован
                    "http://example.com?login=a&pass=123"
            );

            BufferedReader bin = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;

            while ((line = bin.readLine()) != null)
                System.out.println(line);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
