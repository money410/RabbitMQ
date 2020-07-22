package com.money.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 19:10
 */
@Component
@RabbitListener(queues = "qname_topic_money02")
public class TopicListener2 {
    @RabbitHandler
    public void handler(String msg){
        System.out.println("topic消费者02------"+msg);
    }

}
