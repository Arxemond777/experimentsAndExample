package ch10_works_with_text;


import java.io.UnsupportedEncodingException;

public class A {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s1 = "Cat", s2 = "Cat";
        String s3 = new String("Cat");
        String s4 = new String("Cat");
//        s3 = s3.intern();
        // сравниваем наши строки
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s3));
        System.out.println(s1 == s3);
        s3 = s3.intern();
        System.out.println(s1 == s3);
//        System.out.println(s3 == s4);
        System.exit(1);

        char [] data = new char[] {'A', 'b', 'c'};
        String charToString = new String(data);
        System.out.println("charToString: " + charToString);

        byte [] dataB = new byte[] {(byte)96, (byte)97, (byte)98, (byte)99};
        String charToByte = new String(dataB, "ISO8859_1");
        System.out.println(charToByte);
    }
}
