package com.money.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 13:44
 */
@RestController
public class FanoutController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("api/mq/fanoutmsg")
    public String sendFanoutMsg(String msg){
        rabbitTemplate.convertAndSend("ex_fanout_money",null,msg);
        return "ok";
    }

}
