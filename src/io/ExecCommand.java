package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * http://www.rgagnon.com/javadetails/java-0014.html
 */
public class ExecCommand {
    public static void main(String[] args) throws IOException {
        Process exec = Runtime.getRuntime().exec("ls -la /");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        System.exit(1);
    }
}
