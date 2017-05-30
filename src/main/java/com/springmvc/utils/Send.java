package com.springmvc.utils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
    private final static String QUEUE_NAME = "rabbit";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.153.129");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("172594");
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello 草拟吗";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}