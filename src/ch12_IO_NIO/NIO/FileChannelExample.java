package ch12_IO_NIO.NIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption.*;
import java.util.Date;


//import static java.nio.file.AccessMode.WRITE;
//import static java.nio.file.StandardOpenOption.APPEND;

import static java.nio.file.StandardOpenOption.*;

public class FileChannelExample
{
    public static void main(String[] args) throws FileNotFoundException {
//        FileChannelExample.A();
//        FileChannelExample.B();
//        FileChannelExample.B1();
//        FileChannelExample.C();
        FileChannelExample.D();
    }

    public static void A() {
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("/tmp/bar.txt");
        try (
                FileChannel fileChannel = FileChannel.open(path, WRITE, APPEND, DSYNC); //DSYNC - атомарность на все в файле, включая метаданные, SYNC ток на содержимое файла
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            System.out.println(Charset.defaultCharset());
//            while (fileChannel.read(buffer, 1) != -1) { //читать пискать с какого-то места, как в RandomAccess
            while (fileChannel.read(buffer, 1) != -1) {
                buffer.flip();
                System.out.print(Charset.defaultCharset().decode(buffer));
                buffer.clear();
            }
            while (fileChannel.read(buffer) != -1) {
                buffer.flip();
                System.out.println(Charset.defaultCharset().decode(buffer));
//                System.out.println("String read: " + ((ByteBuffer) (buffer.flip())).asCharBuffer().get(0));
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(File.separator); // /
//        System.out.println(File.pathSeparator); // :
    }

    public static void B() {
//        try (
//                FileChannel readOnlyFc = new FileInputStream("/tmp/bar.txt").getChannel();
//                FileChannel readWriteFc = new RandomAccessFile("/tmp/bar.txt", "rw").getChannel();
//        ) {
//            ByteBuffer buffer = ByteBuffer.allocate(1);
//            StringBuffer line = new StringBuffer();
//            while (readWriteFc.read(buffer) > 0) {
//                buffer.flip();
//                for (int i = 0; i < buffer.limit(); i++) {
//                    char ch = ((char) buffer.get());
//                    System.out.println(ch);
//                    /*if (ch == '\r') {
//                        System.out.print(line + "[EOL]");
//                        line = new StringBuffer();
//                    } else {
//                        line.append(ch);
//                    }*/
//                }
//                buffer.clear(); // do something with the data and clear/compact it.
//            }
//
//            System.out.println(readWriteFc.isOpen());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void B1() {
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("/tmp/bar.txt");
        try (
                FileChannel readOnlyFc = new FileInputStream("/tmp/bar.txt").getChannel();
                FileChannel readWriteFc = new RandomAccessFile("/tmp/bar.txt", "rw").getChannel();
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            buffer.clear(); //сбрасывает значение позиции в 0 на начало строки
//            buffer.reset(); //как clear возвращает значение позиции но не в 0, а к метке
            readOnlyFc.position(1); // Взяли все со второго (1)
            readOnlyFc.read(buffer);
            buffer.flip(); //запись и чтение данных из буфера
            readWriteFc.write(buffer);// И записали
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void C() {
        FileSystem fs = FileSystems.getDefault();
        try (FileChannel fc = FileChannel.open(fs.getPath("/tmp/bar.txt"), CREATE, READ, WRITE);) {

            System.out.println(123);
//            MappedByteBuffer mappedByteBuffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size());
//            System.out.println(mappedByteBuffer.get());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void D()
    {
        FileSystem fs = FileSystems.getDefault();
        Path fromFile = fs.getPath("/tmp/input_ch9.txt");
        Path toFile = fs.getPath("/tmp/out_ch9.txt");

        try (
                FileChannel in = FileChannel.open(fromFile);
                FileChannel out = FileChannel.open(toFile, CREATE, WRITE);
                ) {
            System.out.println("Start: " + new Date().toString());
            in.transferTo(0, (int)in.size(), out);
            System.out.println("End: " + new Date().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
