package ch13_network_progrmming;

import java.net.*;
import java.io.*;
import java.util.List;
import java.util.regex.*;
import java.util.concurrent.*;

public class TinyHttpd
{
    public static void main(String argv[]) throws IOException, URISyntaxException {
        //________________________________________________
        //Смотрим настройки прокси средставми API java
//        ProxySelector ps = java.net.ProxySelector.getDefault();
//        List list = ps.select(new URI("http://java.sun.com/"));
//        System.out.println(list.get(0));
        //________________________________________________
        Executor executor = Executors.newFixedThreadPool(3);
        ServerSocket ss = new ServerSocket(Integer.parseInt(argv[0]));

        /** Alternative variant with timeout await socket */
        /*ss.setSoTimeout(2000); //время ожидания
        boolean shutdown = true;
        while (shutdown) {
            try {
                executor.execute(new TinyHttpdConnection(ss.accept()));
            } catch (InterruptedIOException e) {
                ss.close();
                shutdown = false;
            }
        }*/

        while (true)
            executor.execute(new TinyHttpdConnection(ss.accept()));
    }
}

class TinyHttpdConnection implements Runnable
{
    //TODO работает в SAFARI
    /**
     * Запуск javac -d out/production/HelloWorld/ src/ch13_network_progrmming/TinyHttpd.java; java -cp out/production/HelloWorld/ ch13_network_progrmming.TinyHttp1235
     *
     * В SAFARI !! http://localhost:1235/index1.html
     *
     * берет из корневой директории, где запущен сайт System.getProperty("user.dir")
     * в нашем случа /Users/urijglusenkov/InteliJ/HelloWorld/index.html
     */
    Socket client;

    TinyHttpdConnection(Socket client) throws SocketException {
        this.client = client;
//        System.out.println( //Стр 659
//                "Algorithm Neigla: " + client.getTcpNoDelay() + ";" //Алгоритм Нейгла задерживает мелкие порции TCP, чтоб отрпавлять их пачками, а не сразу
//                + "\nЧто делать с данными, которые не отправленны, а уже вызвался метод .close(): " + client.getSoLinger() + ";"
//
//        );
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream(), "8859_1"));
            OutputStream out = client.getOutputStream();
            PrintWriter pout = new PrintWriter(
                    new OutputStreamWriter(out, "8859_1"), true);
            String request = in.readLine();
            System.out.println("Request: " + request);

            Matcher get = Pattern.compile("GET /?(\\S*).*").matcher(request);
            if (get.matches()) {
                request = get.group(1);
                if (request.endsWith("/") || request.equals(""))
                    request = request + "index.html";
                System.out.println("Working Directory = " + System.getProperty("user.dir"));
                try {
                    FileInputStream fis = new FileInputStream(request);
                    byte[] data = new byte[64 * 1024];
                    for (int read; (read = fis.read(data)) > -1; )
                        out.write(data, 0, read);
                    out.flush();
                    System.out.println("success");
                } catch (FileNotFoundException e) {
                    pout.println("404 Object Not Found");
                    System.out.println(e);
                } catch (SecurityException e) {
                    //Если хотим ВКЛ секьюрити менеджер, чтоб нельзя было лазить везде 649 | 659 страница
                    System.out.println("Perm dined: " + e);
                }
            } else
                pout.println("400 Bad Request");
            client.close();
        } catch (IOException e) {
            System.out.println("I/O error " + e);
        }
    }
}
