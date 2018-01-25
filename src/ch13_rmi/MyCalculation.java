package ch13_rmi;

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
