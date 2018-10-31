package opcode;

class Diversion {
    static void Convert() {

        byte imByte = 0;
        int imInt = 125;
//        int imInt = 129;
        while (true) {
            ++imInt;
            imByte = (byte) imInt;
            imInt *= -1;
            imByte = (byte) imInt;
            imInt *= -1;
        }
    }
}
