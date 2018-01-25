package ch12_IO_NIO.IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomAccessFileExample
{
    static int count = 0;

    public static void main(String[] args) throws IOException {
        RandomAccessFile user = new RandomAccessFile(new File("/tmp/users.txt"), "rw");
        System.out.println(user.length());

        DateFormat format = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss");
        Date date = new Date();
//        user.writeUTF(format.format(date) + System.lineSeparator());

        RandomAccessFileExample.read(user);

        user.seek((long)Math.ceil(user.length() / 2));
        user.writeUTF("123");

        RandomAccessFileExample.read(user);

        user.close();
//        user.seek(l);
    }

    static void read(RandomAccessFile user) {
        try {
            int s;
            String res = "";
            while ((s = user.read()) != -1) {
                res = res + (char) s;

            }

            System.out.println(
                    ++RandomAccessFileExample.count
                            + System.getProperty("line.separator")
                            + res
            );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
