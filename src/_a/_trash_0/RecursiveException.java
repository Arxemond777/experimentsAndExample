package _a._trash_0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

interface Alala
{

}

public class RecursiveException
{
    private int getRandomInt() {
        return ThreadLocalRandom.current().nextInt(1, 10 + 1);
    }

    private Alala getAlalaClass() {
        int randomInt = getRandomInt();

        if (randomInt <= 9)
            return new ATestGeneric();
        else
            return new BTestGeneric();
    }

    @SuppressWarnings("unchecked")
    private void something() {
        new Thread(() -> {
            List<ATestGeneric> aTestGenerics = new ArrayList<>();

            while (true) {
                Alala alala = new RecursiveException().getAlalaClass();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(alala.getClass().getName());

                aTestGenerics.add((ATestGeneric) alala);
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws InterruptedException {

        new RecursiveException().something();

    }
}

class ATestGeneric implements Alala
{
}

class BTestGeneric implements Alala
{
}