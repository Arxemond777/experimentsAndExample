package ch3_tools_for_works;

import java.net.*;

public class EvilEmpire {

    public static void main(String [] args) throws Exception {
        try {
            Socket s = new Socket("207.46.131.13", 80);
            System.out.println("Подключенно.");

        } catch (SecurityException e) {
            System.out.println("SecurityException: не удалось подключиться123." + e);
        }
    }

}