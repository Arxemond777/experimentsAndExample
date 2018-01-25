package ch13_rmi;

import java.rmi.*;

public class MyClientAsync extends java.rmi.server.UnicastRemoteObject
    implements WorkListener
{
    public MyClientAsync(String host) throws RemoteException {
        try {
            ServerRemote server
                    = (ServerRemote) Naming.lookup("rmi://" + host + "/NiftyServer");
            server.asyncExecute(new MyCalculation(3), this);
            System.out.println("Call done...");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void workComleted(WorkRequest request, Object result) throws RemoteException {
        System.out.println("async result: " + result);
    }

    public static void main(String[] args) throws RemoteException {
        new MyClientAsync("localhost");
    }
}
