public class BytesOperations {
    public static void main(String[] args) {
        byte b = 14;

        a(b);
        a(b >> 1);
        a(b << 2);
        a(b >>> 1);

        System.out.println("_______");
        System.out.println(b >>> 1);
        //System.out.println(Integer.toHexString(b));
    }

    static void a(int b) {
        String s1 = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
        System.out.println("int:" + b + System.lineSeparator() + " | byte:" + s1);
    }
}
