package ch13_network_progrmming;

import java.io.*;
import java.net.*;

public class Pulse
{
    public static void main(String[] args) throws IOException {
        DatagramSocket s = new DatagramSocket(Integer.parseInt(args[0]));

//        InetAddress addr = InetAddress.getByName("google.com");
//        System.out.println(addr);
//        byte[] data = "aaa".getBytes("UTF-8");
//        String d_decode = new String(data, "UTF-8");
//        System.out.println(data);
//        System.out.println(d_decode);
//        System.exit(1);

        while (true) {
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            //System.out.println("Start pulse on port: " + Integer.parseInt(args[0]));
            s.receive(packet);
            //System.out.println("packet length = " + packet.getData().length);
            String message = new String(packet.getData(), "UTF-8");
            System.out.println("Heartbeat from: "
                    + packet.getAddress().getHostName()
                    + " - " + message);
        }
    }
}
