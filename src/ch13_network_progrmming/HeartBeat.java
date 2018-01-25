package ch13_network_progrmming;

import java.net.*;
import java.io.*;

public class HeartBeat extends java.applet.Applet
{
    String myHost;
    int myPort;

    public HeartBeat() {}

    public void init() {
        myHost = "localhost";
        myPort = 1556;
    }

    private void sendMessage(String message) {
        try {
            byte [] data = message.getBytes("UTF-8");
            InetAddress addr = InetAddress.getByName( myHost );
            DatagramPacket pack =
                    new DatagramPacket( data, data.length, addr, myPort );
            DatagramSocket ds = new DatagramSocket();
            ds.send( pack );
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        sendMessage("Arrived");
    }

    public void stop() {
        sendMessage("Departed");
    }
}
