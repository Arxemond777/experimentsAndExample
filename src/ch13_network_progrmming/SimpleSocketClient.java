package ch13_network_progrmming;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleSocketClient
{
    public static void main(String[] args) {
        SimpleSocketClient.client();
    }

    public static void client() {
        try {
            System.out.println("Start client");
            Socket server = new Socket("127.0.0.1", 1234);
            InputStream in = server.getInputStream();
            OutputStream out = server.getOutputStream();

            out.write(42);

            PrintWriter pout = new PrintWriter(out, true);
            pout.println("Hello1");

            byte back = (byte) in.read();
            System.out.println(back);

            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            String response = bin.readLine();
            System.out.println(response);

            ObjectOutputStream oout = new ObjectOutputStream(out);
            oout.writeObject(new java.util.Date());
            oout.flush();

            server.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
