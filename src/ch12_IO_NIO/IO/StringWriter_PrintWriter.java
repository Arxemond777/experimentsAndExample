package ch12_IO_NIO.IO;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StringWriter_PrintWriter
{
    public static void main(String[] args) {//shift + f6
        StringWriter buffer = new StringWriter();
        PrintWriter out = new PrintWriter(buffer);
        out.print("My ");
        out.println("sister");

        String results = buffer.toString();
        StringBuffer sb = buffer.getBuffer();
        System.out.println(sb);
    }
}
