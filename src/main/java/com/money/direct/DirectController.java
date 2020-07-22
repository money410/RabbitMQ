package com.money.direct;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 14:43
 */
@RestController
public class DirectController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("api/mq/directmsg")
    public String sendDirectMsg(String key,String msg){
        System.out.println(key+"======="+msg);
        rabbitTemplate.convertAndSend("ex_direct_money",key,msg);
        return "ok";
    }
}
