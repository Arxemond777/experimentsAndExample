package ch13_network_progrmming.rmi;

import java.rmi.*;
import java.util.*;
import ch13_network_progrmming.simple_serialized_object_protocols.*;

public interface ServerRemote extends Remote
{
    Date getDate() throws RemoteException;
    Object execute(WorkRequest work) throws RemoteException;
}
