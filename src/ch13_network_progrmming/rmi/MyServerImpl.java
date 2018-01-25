package ch13_network_progrmming.rmi;

import java.rmi.*;
import java.util.*;
import ch13_network_progrmming.simple_serialized_object_protocols.*;

public class MyServerImpl extends java.rmi.server.UnicastRemoteObject
    implements ch13_network_progrmming.rmi.ServerRemote
{
    public MyServerImpl() throws RemoteException {}

    @Override
    public Date getDate() throws RemoteException {
        return new Date();
    }

    @Override
    public Object execute(WorkRequest work)
        throws RemoteException {
        return work.execute();
    }

    public static void main(String[] args) {
        try {
            ch13_network_progrmming.rmi.ServerRemote server = new MyServerImpl();
            Naming.rebind("NiftyServer", server);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
