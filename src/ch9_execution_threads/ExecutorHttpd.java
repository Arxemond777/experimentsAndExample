package ch9_execution_threads;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecutorHttpd {
    public static void main(String[] args) throws Exception {
        System.out.println(args[0]);
        new ExecutorHttpd().start(Integer.parseInt(args[0]));
    }

    ExecutorService executor = Executors.newFixedThreadPool(3);
//    ExecutorService es = Executors.defaultThreadFactory();

    public void start(int port) throws IOException {
        final ServerSocket ss = new ServerSocket(port);
        while (!executor.isShutdown())
            executor.submit(new TinyHttpdConnection(ss.accept()));
    }

    public void shutdown() throws InterruptedException {
        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);
        executor.shutdownNow();
    }
}

class TinyHttpdConnection implements Runnable {
    Socket client;
    TinyHttpdConnection(Socket client) throws SocketException {
        this.client = client;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream(), "8859_3")
            );
            OutputStream out = client.getOutputStream();
            PrintWriter pout = new PrintWriter(
                    new OutputStreamWriter(out, "8859_3"), true
            );
            String request = in.readLine();
            System.out.println("Request: " + request);

            Matcher get = Pattern.compile("GET /?(\\S*).*").matcher(request);
            if (get.matches()){
                request = get.group(1);
                if (request.endsWith("/") || request.equals("")) {
                    request = request + "index.html";
                }
                try {
                    FileInputStream fis = new FileInputStream(request);
                    byte [] data = new byte[64*1024];
                    for(int read; (read = fis.read(data)) > -1;)
                        out.write(data, 0, read);
                    out.flush();
                } catch (FileNotFoundException e) {
                    pout.println("404 Object Not Found");
                }
            } else
                pout.println("400 Bad Request");
            client.close();
        } catch (IOException e) {
            System.out.println("I/O error " + e);
        }
    }
}
