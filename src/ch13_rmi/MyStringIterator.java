package ch13_rmi;

import java.rmi.*;

public class MyStringIterator extends java.rmi.server.UnicastRemoteObject
    implements StringIterator
{

    String [] list;
    int index = 0;

    protected MyStringIterator(String [] list)
            throws RemoteException {
        this.list = list;
    }

    @Override
    public boolean hasNext() throws RemoteException {
        return index < list.length;
    }

    @Override
    public String next() throws RemoteException {
        return list[index++];
    }
}
