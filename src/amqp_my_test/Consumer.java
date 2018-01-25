package amqp_my_test;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer
{
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(Producer.getQueueName(), false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel)
        {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(Producer.getQueueName(), true, consumer);
    }
}