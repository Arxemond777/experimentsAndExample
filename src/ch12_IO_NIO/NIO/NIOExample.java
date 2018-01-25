package ch12_IO_NIO.NIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

public class NIOExample
{
    public static void main(String[] args) {
//        NIOExample.A();
//        NIOExample.B();
//        NIOExample.С();
//        NIOExample.D();
        NIOExample.E();
    }

    public static void A() {
        FileSystem fs = FileSystems.getDefault();
        for (FileStore store : fs.getFileStores()) {
            printDetails(store);
        }

        URI zipURI = URI.create("jar:file:/Users/urijglusenkov/InteliJ/HelloWorld/Primers.zip");
//        FileSystem zipfs = FileSystems.newFileSystem(zipURI, System.getenv());
//        Map<String, String> env = System.getenv();
//        for (String envName : env.keySet()) {
//            System.out.format("%s=%s%n",
//                    envName,
//                    env.get(envName));
//        }
    }

    public static void printDetails(FileStore store) {
        try {
            String desc = store.toString();
            String type = store.type();
            long totalSpace = store.getTotalSpace();
            long unallocatedSpace = store.getUnallocatedSpace();
            long availableSpace = store.getUsableSpace();
            System.out.println(desc + ", Total: " + totalSpace + ",  Unallocated: "
                    + unallocatedSpace + ",  Available: " + availableSpace);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void B() {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        Calendar calendar = Calendar.getInstance();
        Date date1 = calendar.getTime();
        System.out.println(date1);

        FileSystem fs = FileSystems.getDefault();
        Path fooPath = fs.getPath("/tmp/foo.txt");
        try {
            OutputStream out = Files.newOutputStream(fooPath);
            out.write('a');
            out.write('b');
            Path path = fs.getPath("/tmp/foo.txt");
            InputStream in = Files.newInputStream(path);
            System.out.println((char) in.read()); //Потому что надо итерироваться по нему

            /** mv файла*/
            Files.move(fooPath, fooPath.resolveSibling("bar" + dateFormat.format(date) + ".txt"));
            Path path1 = fs.getPath("/tmp/bar.txt");
            System.out.println(1);
            System.out.println(Files.exists(path1));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void С() {
        FileSystem fs = FileSystems.getDefault();
        Charset asciiCharset = Charset.forName("US-ASCII");
        Path csvPath = fs.getPath("/tmp/foo.txt");
        Path newCSVPath = fs.getPath("/tmp/bro.txt");

        try {
            /** Надо ASCII*/
            List<String> csvData = Files.readAllLines(csvPath, asciiCharset);
            Files.write(newCSVPath, csvData, asciiCharset);

//            byte[] data = Files.readAllBytes(dataPath);
//            Files.write(newData, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void D() {
        FileSystem fs = FileSystems.getDefault();
        //Выводим файлы и директории хранящиеся внутри /tmp
        try (
                DirectoryStream<Path> paths =
                        Files.newDirectoryStream(fs.getPath("/tmp"))
        ) {
//            for (Path path : paths)
//                System.out.println(path);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //С шаблоном подстановки
        try (
                DirectoryStream<Path> paths =
                        Files.newDirectoryStream(fs.getPath("/tmp"), "*.txt");
        ) {
//            for (Path path : paths)
//                System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Собственная реализация фильтров
        try (
                DirectoryStream<Path> paths =
                        Files.newDirectoryStream(fs.getPath("/tmp"),
                                new DirectoryStream.Filter<Path>()
                                {
                                    @Override
                                    public boolean accept(Path entry) throws IOException {
                                        return entry.toString().endsWith(".txt");
                                    }
                                });

        ) {
//            for (Path path : paths)
//                System.out.println(path);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Посещаем все файлы в иерархии директории с помощью интерфеса FileVisitor
        try {
            Path paths = Files.walkFileTree(fs.getPath("/tmp"), new SimpleFileVisitor<Path>()
            {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    //System.out.println("Path = " + file);
                    return FileVisitResult.CONTINUE;
                }
            });
            System.out.println(paths);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void E() {
        FileSystem fs = FileSystems.getDefault();
        Path watchPath = fs.getPath("/tmp");

        try {
            WatchService watchService = fs.newWatchService();
            watchPath.register(watchService, OVERFLOW, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);

            while (true) {
                WatchKey chargeKey = watchService.take(); //pool не блокирует
                List<WatchEvent<?>> watchEvents = chargeKey.pollEvents();

                for (WatchEvent<?> watchEvent : watchEvents) {
                    WatchEvent<Path> pathEvent = (WatchEvent<Path>)watchEvent;
                    Path path = pathEvent.context();
                    WatchEvent.Kind<Path> eventKind = pathEvent.kind();
                    System.out.println(eventKind + " for path: " + path);
                }
                chargeKey.reset(); //Важно
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
