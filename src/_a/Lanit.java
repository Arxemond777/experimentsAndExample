package _a;

import java.util.Random;

class AGGGGG
{
    int i;

    @Override
    public int hashCode() {
        return 1;
    }
}

public class Lanit
{

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(2) + 1);
        System.exit(0);

        AGGGGG aggggg = new AGGGGG();
        AGGGGG aggggg1 = new AGGGGG();

        aggggg.i = aggggg1.i = 3;

        System.out.println(aggggg.equals(aggggg1));
        System.out.println(aggggg == aggggg1);
        System.out.println(aggggg.hashCode() + " " + aggggg1.hashCode());
        System.exit(0);

        for (int i = 0; i < 3; i++) {
//            System.out.println(i);
            for (int j = 3; j >= 0; j--) {
//                System.out.println(j);
                if (i == j) continue;
                System.out.println(i + " " + j);
            }
        }

    }

    public static void change(int [] i) {
        i[0] = 2;
    }
}
