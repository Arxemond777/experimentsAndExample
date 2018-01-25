package amqp_my_test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Date;

public class Producer
{

    private final static String QUEUE_NAME = "hello";

    static String getQueueName() {
        return Producer.QUEUE_NAME;
    }

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World! date: " + new Date().toString();
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        channel.basicPublish("", QUEUE_NAME, null, "xer".getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
