package com.money.headers;

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
@RabbitListener(queues = "qname_headers_money02")
public class HeaderListener2 {
    @RabbitHandler
    private void handler(String msg){
        System.out.println("headers消费者02-------"+msg);
    }
}
