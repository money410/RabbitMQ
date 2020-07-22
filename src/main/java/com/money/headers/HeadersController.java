package com.money.headers;

import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 22:06
 */
@RestController
public class HeadersController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("api/mq/headersmsgall")
    public String sendHeadersAllMsg(String msg){

        rabbitTemplate.convertAndSend("ex_headers_money",null,msg,message ->{
            MessageProperties properties = message.getMessageProperties();
            properties.getHeaders().put("ver","1.0");
            properties.getHeaders().put("token","abc001");
            return message;
        },new CorrelationData(UUID.randomUUID().toString()));
        return "ok";
    }

    @GetMapping("api/mq/headersmsgany")
    public String sendHeadersAllMsg2(String msg){

        rabbitTemplate.convertAndSend("ex_headers_money",null,msg,message ->{
            MessageProperties properties = message.getMessageProperties();
            properties.getHeaders().put("version","1.0");
            return message;
        },new CorrelationData(UUID.randomUUID().toString()));
        return "ok";
    }
}
