package ch13_network_progrmming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleSocketServer
{
    public static void main(String[] args) {
        SimpleSocketServer.server();
    }

    public static void server() {
        try {
            ServerSocket listener = new ServerSocket(1234);
            boolean finished = false;

            while (!finished) {
                System.out.println("Accept client");
                Socket client = listener.accept();
                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();

                byte someByte = (byte) in.read();

                BufferedReader bin = new BufferedReader(new InputStreamReader(in));
                String someString = bin.readLine();
                System.out.println("Start! " + someString);

                out.write(43);

                PrintWriter pout = new PrintWriter(out, true);
                pout.println("Goodbye!");

                ObjectInputStream oin = new ObjectInputStream(in);
                Date date = (Date) oin.readObject();
                System.out.println(date);
                client.close();
            }

            listener.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
