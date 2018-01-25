package ch12_IO_NIO.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyChannel
{
    public static void main(String[] args) throws Exception {
        //Самое быстрое копирование на уровне ОС в java (не считая File.copy()), не выкачивая из оперативки в буффер
        String fromFileName = args[0];
        String toFileName = args[1];
        FileChannel in = new FileInputStream(fromFileName).getChannel();
        FileChannel out = new FileOutputStream(toFileName).getChannel();

        ByteBuffer buff = ByteBuffer.allocate(32 * 1024);

        while (in.read(buff) > 0) {
            buff.flip();
            out.write(buff);
            buff.clear();
        }

        in.close();
        out.close();
    }
}


