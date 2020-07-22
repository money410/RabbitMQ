package com.money.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 18:39
 */
@RestController
public class TopicController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("api/mq/topicmsg")
    public String sendTopicMsg(String key,String msg){
//        System.out.println(key+"====="+msg);
        rabbitTemplate.convertAndSend("ex-topic-money",key,msg);
        return "ok";
    }
}
