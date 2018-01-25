package ch13_network_progrmming.rmi;

import java.rmi.*;
import java.util.*;
import ch13_network_progrmming.simple_serialized_object_protocols.*;

public class MyClient
{
    public static void main(String[] args) throws RemoteException {
        new MyClient("localhost");
    }

    public MyClient (String host) {
        try {
            ch13_network_progrmming.rmi.ServerRemote serverRemote
                    = (ch13_network_progrmming.rmi.ServerRemote) Naming.lookup("rmi://" + host + "/NiftyServer");
            System.out.println(serverRemote.getDate());
            System.out.println(serverRemote.execute(new MyCalculation(2)));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
