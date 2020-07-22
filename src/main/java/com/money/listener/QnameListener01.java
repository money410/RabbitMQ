package com.money.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 11:16
 */
@Component
@RabbitListener(queues = "qname_work_money")//设置要监听的队列
public class QnameListener01 {
    @RabbitHandler //修饰方法 实现消息的接受
    public void handler(String msg){
        System.out.println("work模式消费者01------"+msg);
    }
}
