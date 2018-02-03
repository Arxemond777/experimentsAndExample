package binaryoperations;

public class Example {
    public static void main(String[] args) {
        // & AND
        int i = 110;
        int i1 = 100;
        int i2 = 10;

        /**
         * i & i1=
         * с конца
         * 110 | 0 | 1 | 1 | (00000110)
         *     | & | & | & |
         * 100 | 0 | 0 | 1 | (00000100)
         * => 100
         * i & i2=
         * с конца
         * 110 | 0 | 1 | 1 | (00000110)
         *     | & | & | & |
         * 010 | 0 | 0 | 1 | (00000010)
         * => (0)10
         */
        System.out.println(i & i1);
        System.out.println(i & i2); // обычное бинарное & 1&0=0, 0&0=0, 1&1=1

        // | OR

        // ~ NOT (~0=1; ~1=0)

        // ^ XOR (0^0=0; 1^1=0; 1^0=0; 0^1=1)

        // >> right shift (divide) | << left shift (multiply)
        int x = 14; // Bit pattern 00001110
        int y = x >> 1; // here we have the bit pattern shifted by 1 thus we get 00000111 = 7 which is 14/2

        System.out.printf("%d\n", y);

        y = y; // 00000111
        int jj = y << 1; // 00001110
        System.out.println(jj);
        int iii = getbits(jj, 5, 4); // 4, 3, 2 бит прижимая их к правому краю
        System.out.printf("4, 3, 2 бит прижимая их к правому краю: %d=%d\n", iii, jj);
        System.out.printf("%d\n", jj);

        jj = jj << 1; // 00011100
        System.out.printf("%d\n", jj);

        jj = jj << 2; // 001110000
        System.out.printf("%d\n", jj);

    }

    static int getbits(int x, int p, int n) {
        return (x >> (p + 1 - n)) & ~(~0 << n);
    }
}
