package com.money.client;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 10:41
 */
public class ReceiveMsg_Main {
    public static void main(String[] args) throws IOException, TimeoutException {
        //服务器地址：182.92.77.178 5672 账号密码：guest guest
        //设置连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("182.92.77.178");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        //获取连接对象
        Connection connection = factory.newConnection();
        //创建通道对象
        Channel channel = connection.createChannel();

        channel.basicConsume("qname_money",new DefaultConsumer(channel){
            //处理消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者："+new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });

        //关闭、销毁
//        channel.close();
//        connection.close();
    }
}
