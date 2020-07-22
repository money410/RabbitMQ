package com.money.deadletter;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 22:31
 */
@Configuration
public class RabbitDeadLetterConfig {
    @Bean
    public Queue createQ01(){
        Map<String,Object> args=new HashMap<>();
        //设置队列内部的消息的有效期 10秒
        args.put("x-message-ttl",10000);
        //设置死信交换器名称
        args.put("x-dead-letter-exchange","dead-study");
        //设置匹配路由
        args.put("x-dead-letter-routing-key","order-timeout");
        //创建队列 设置队列的名称，和对应的属性
        return QueueBuilder.durable("qname-time-order").withArguments(args).build();
    }

    //死信队列 超时订单
    @Bean
    public Queue createQ02(){
        return new Queue("qname-timeout-order");
    }

    //死信交换器 注意要和延迟队列绑定的交换器一致
    @Bean
    public DirectExchange createExx(){
        return new DirectExchange("dead-study");
    }

    //绑定交换器和队列 实现死信交换器和死信队列的绑定
    //注意 路由器的名称需要和延迟队列中绑定的名称一致
    @Bean
    public Binding createBd(DirectExchange ex){
        return BindingBuilder.bind(createQ02()).to(ex).with("order-timeout");
    }
}
