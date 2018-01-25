package ch13_network_progrmming.simple_serialized_object_protocols;

import ch13_rmi.Request;

public abstract class WorkRequest extends Request
{
    public abstract Object execute();
}
