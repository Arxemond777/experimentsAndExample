package ch12_IO_NIO.IO;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class rot13
{
    public static void main(String[] args) {
        InputStream ris = new Rot13InputStream(System.in);
        try {
            System.out.println("Enter text");
            System.out.println(ris.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Rot13InputStream extends FilterInputStream
{
    public Rot13InputStream(InputStream i) {
        super(i);
    }

    public int read() throws IOException {
        return this.rot13(in.read());
    }

    private int rot13(int c) {
        if ((c >= 'A') && (c <= 'Z'))
            c=(((c-'A')+13)%26)+'A';
        if ((c >= 'a') && (c <= 'z'))
            c=(((c-'z')+13)%26)+'a';
        return c;
    }
}
