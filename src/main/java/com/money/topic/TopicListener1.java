package com.money.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 19:06
 */
@Component
@RabbitListener(queues = "qname_topic_money01")
public class TopicListener1 {
    @RabbitHandler
    private void handler(String msg){
        System.out.println("topic消费者01-------"+msg);
    }
}
