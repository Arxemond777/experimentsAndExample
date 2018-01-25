package ch12_IO_NIO.NIO;

import java.io.*;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ZFPExample
{
    public static void main(String[] args) {
        URI zipUri = URI.create("jar:file:/Users/urijglusenkov/InteliJ/HelloWorld/out/production/HelloWorld/ch12_IO_NIO/NIO/MyArchive.zip");

        Map<String, String> env = new HashMap<>();
        env.put("create", "true");

        try (FileSystem zipf = FileSystems.newFileSystem(zipUri, env)) {
            //созадли
            /*Path path = zipf.getPath("/README.txt");
            OutputStream out = Files.newOutputStream(path);
            try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(out))) {
                pw.println("Hello world");
            }*/

            //переместили
            Path path = zipf.getPath("/README.txt");
            Path toPath = zipf.getPath("/README1.txt");
            Files.move(path, toPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
