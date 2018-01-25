package ch_14_web_programming_client_side;

import java.awt.image.ImageProducer;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class page_709_FileGetContentImageToObject
{
    public static void main(String[] args) {
        try {
            String gif = "http://i.imgur.com/RRUe0Mo.png";
            URL url = new URL(gif);
            ImageProducer ip = (ImageProducer)url.getContent();

            System.out.println(ip);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            URLConnection connection = url.openConnection(); //Тут еще не связался
            /**Пока не связался, можно установить параметры или фильтры */
            connection.setConnectTimeout(10_000);
            connection.setReadTimeout(10_000);

            InputStream in = connection.getInputStream(); //Связался или при запросе данных

            System.out.println(connection.getContentType());
            System.out.println(in);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
