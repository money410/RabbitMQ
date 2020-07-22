package com.money.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 14:49
 */
@Component
@RabbitListener(queues = "qname_direct_money2")
public class DirectListener02 {
    @RabbitHandler//修饰方法 实现消息的接收
    public void handler(String msg){
        System.out.println("direct消费者02------"+msg);
    }


}
