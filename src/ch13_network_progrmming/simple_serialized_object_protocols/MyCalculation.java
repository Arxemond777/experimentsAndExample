package ch13_network_progrmming.simple_serialized_object_protocols;

public class MyCalculation extends WorkRequest
{
    int n;

    public MyCalculation(int n) {
        this.n = n;
    }

    @Override
    public Object execute() {
        return new Integer(this.n * this.n);
    }
}
