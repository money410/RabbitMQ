package com.money.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 11:12
 */
@RestController
public class MqController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("api/mq/sendmsg")
    public String sendMsg(String msg){
        rabbitTemplate.convertAndSend("qname_money",msg);
        return "ok";
    }

    //
    @GetMapping("api/mq/workmsg")
    public String sendWorkMsg(String msg){
        rabbitTemplate.convertAndSend("qname_work_money",msg);
        return "ok";
    }
}
