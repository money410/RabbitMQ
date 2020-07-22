package com.money.deadletter;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 22:47
 */
@Component
@RabbitListener(queues = "qname-timeout-order")
public class DeadLetterListener {
    @RabbitHandler
    public void handler(String msg){
        System.out.println("消息--->"+msg+"------>"+System.currentTimeMillis()/1000);
    }
}
