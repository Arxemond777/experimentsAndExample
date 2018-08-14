package _a._trash_1.socket;

import java.io.*;
import java.net.*;

public class Server {
    public final static int portNumber = 4444;
    public final static String hostName = "localhost";

    public static void main(String[] args) {

        try (
                ServerSocket serverSocket = new ServerSocket(Server.portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {

            String inputLine, outputLine;

            // Initiate conversation with client
            KnockKnockProtocol kkp = new KnockKnockProtocol();
            outputLine = kkp.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = kkp.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye."))
                    break;
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + Server.portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
