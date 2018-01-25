package ch13_network_progrmming.simple_serialized_object_protocols;

import java.net.*;
import java.io.*;

public class Client
{
    public static void main(String[] args) {
        try {
            Socket server = new Socket("127.0.0.1", Server.PORT);

            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            out.writeObject(new DateRequest());
            out.flush();
            System.out.println(in.readObject());

            out.writeObject(new MyCalculation(2));
            out.flush();
            System.out.println(in.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
