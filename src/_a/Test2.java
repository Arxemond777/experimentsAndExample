package _a;

public class Test2 {
    public static void main(String[] args) {
        int[] data = new int[1 << 10];

        System.out.println(1 << 10);
        System.out.println(2 << 10);

        System.out.println(Integer.parseInt("00001101", 2));
        System.out.println(Integer.parseInt("00000001", 2));
        System.out.println("----");
        System.out.println(Integer.parseInt("00011100", 2));
        System.out.println("----");
        System.out.println(Integer.toString(28, 2));
        System.out.println(String.format("%8s", Integer.toBinaryString(28)).replace(' ', '0'));
        System.out.println("----");
        System.out.println(Integer.toBinaryString(28));

        String s = "" + 122;
        System.out.println(s);
    }
}

//0000_0001
//0000_0010
//0000_0011
//0000_0100
//0000_0101
//
//0000_0111
//0000_1000
//0000_1001
//0000_1011
//0000_1100