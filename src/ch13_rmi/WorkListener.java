package ch13_rmi;

import java.rmi.*;

public interface WorkListener extends Remote
{
    public void workComleted(WorkRequest request, Object result)
        throws RemoteException;
}
