package ch9_execution_threads;

public class Exchanger {
    //TODO dose`t work
    /*public static void main(String[] args) throws InterruptedException {
        java.util.concurrent.Exchanger<ByteBuffer> x = new java.util.concurrent.Exchanger<>();

        byte [] b1 = new byte[10];
        ByteBuffer buffer1 = ByteBuffer.wrap(b1);
        System.out.println(1);

        byte [] b2 = new byte[10];
        ByteBuffer buffer2 = ByteBuffer.wrap(b1);

        try {

            Buffer nextBuf = x.exchange(buffer1);
            System.out.println("1 " + nextBuf);
            nextBuf = x.exchange(buffer2);
            System.out.println("2 " + nextBuf);

        } catch (InterruptedException e) {
            System.out.println("3 " + 3);
        }
    }*/
}
