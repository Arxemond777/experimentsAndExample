package ch12_IO_NIO.IO;

import java.io.*;

public class Сonveyer
{
    public static void main(String[] args) throws IOException {
        PrintWriter out = new LoggerDaemon().getWriter();

        out.println("Application started...");
        out.println("Attention");
    }
}

class LoggerDaemon extends Thread
{
    public PipedReader in = new PipedReader();

    LoggerDaemon() {
        System.out.println(2);
        start();
    }

    public void run() {
        BufferedReader bin = new BufferedReader(in);
        String s;
        try {
            System.out.println(bin.readLine());
            while ((s = bin.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    PrintWriter getWriter() throws IOException {
        return new PrintWriter(new PipedWriter(in));
    }
}
