package ch13_network_progrmming.simple_serialized_object_protocols;

import java.net.*;
import java.io.*;

public class Server
{
    static final int PORT = 1236;

    /**
     * Тут применяется шаблон "команда" - цель которого создание структуры,
     * в которой класс-отправитель и класс-получатель не зависят друг от друга
     * напрямую. Организация обратного вызова к классу, который включает в
     * себя класс-отправитель.
     *
     * Назначение: для обработки команды в виде объекта
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
//        ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));
        ServerSocket ss = new ServerSocket(PORT);
        while (true)
            new ServerConnection(ss.accept()).start();
    }
}

class ServerConnection extends Thread
{
    Socket client;

    public ServerConnection(Socket client) throws SocketException {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());

            while (true) {
                out.writeObject(processRequest(in.readObject()));
                out.flush();
            }
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Вот тут делается часть команды, которая реализ новое
    //действие
    private Object processRequest(Object request) {
        if (request instanceof DateRequest)
            return new java.util.Date();
        else if (request instanceof WorkRequest)
            return ((WorkRequest)request).execute();
        else
            return null;
    }
}