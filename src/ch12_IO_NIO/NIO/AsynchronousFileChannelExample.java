package ch12_IO_NIO.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class AsynchronousFileChannelExample
{
    public static void main(String[] args) {
        FileSystem fileSystem = FileSystems.getDefault();
        Path path = fileSystem.getPath("/tmp/bar.txt");

        try {
            AsynchronousFileChannel channnel = AsynchronousFileChannel.open(path);
            ByteBuffer bbuf = ByteBuffer.allocate(1024);
            Object o = new Integer(1);
            Integer offset = new Integer(1);

            channnel.read(bbuf, offset, o,
                    new CompletionHandler<Integer, Object>()
                    {

                        @Override
                        public void completed(Integer result, Object attachment) {
                            System.out.println("Read byte: " + result);
                        }

                        @Override
                        public void failed(Throwable exc, Object attachment) {
                            System.out.println(1);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
