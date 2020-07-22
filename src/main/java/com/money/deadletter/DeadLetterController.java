package com.money.deadletter;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 22:44
 */
@RestController
public class DeadLetterController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("api/mq/dlxsmg")
    public String sendMsg(String msg){
        System.out.println("发送消息----->"+msg+"----->"+System.currentTimeMillis()/1000);
        rabbitTemplate.convertAndSend(null,"qname-time-order",msg);
        return "ok-"+System.currentTimeMillis();
    }
}
