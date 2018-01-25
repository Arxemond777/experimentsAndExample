package ch13_rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Date;

public class MyServer extends java.rmi.server.UnicastRemoteObject
    implements ServerRemote
{
    public static void main(String[] args) {
        try {
            ServerRemote server = new MyServer();
            Naming.rebind("NiftyServer", server);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    protected MyServer() throws RemoteException {
    }

    @Override
    public Date getDate() throws RemoteException {
        return new Date();
    }

    @Override
    public Object execute(WorkRequest work)
            throws RemoteException {
        return work.execute();
    }

    public StringIterator getList() throws RemoteException {
        return new MyStringIterator(
                new String[] {"Foo", "Bar", "Gee"}
        );
    }

    public void asyncExecute(final WorkRequest request, final WorkListener listener)
        throws RemoteException {
        new Thread() {
            @Override
            public void run() {
                Object result = request.execute();
                try {
                    listener.workComleted(request, result);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
