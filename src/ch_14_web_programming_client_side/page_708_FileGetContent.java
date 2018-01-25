package ch_14_web_programming_client_side;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class page_708_FileGetContent
{
    public static void main(String[] args) throws IOException {
        BufferedReader bin = null;
        try {
            URL url = new URL("https://google.com");
            bin = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;

            while ((line = bin.readLine()) != null)
                System.out.println(line);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bin != null)
                bin.close();
        }
    }
}
