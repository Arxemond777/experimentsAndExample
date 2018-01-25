package ch12_IO_NIO.IO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GetResourceExample
{
    public static void main(String[] args) throws IOException {
        URL resource = GetResourceExample.class.getResource("/ch12/IO/config.xml");
        System.out.println(resource);

        URL resource3 = GetResourceExample.class.getResource("config.xml");
        System.out.println(resource3);

        GetResourceExample gre = new GetResourceExample();
        URL resource4 = gre.getClass().getResource("/ch12/IO/config.xml");
        System.out.println(resource4);


        InputStream resource1 = GetResourceExample.class.getResourceAsStream("config.xml");
        System.out.println(resource1.read());
    }
}
