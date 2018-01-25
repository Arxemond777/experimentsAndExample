package com.company;

import java.net.*;

public class EvilEmpire {

    public static void main(String [] args) throws Exception {
        try {
            Socket socket = new Socket("207.46.131.13", 80);
            System.out.println("Подключенно.");

        } catch (SecurityException e) {
            System.out.println("SecurityException: не удалось подключиться.");
        }
    }

}
