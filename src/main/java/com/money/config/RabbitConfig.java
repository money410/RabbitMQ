package com.money.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 11:09
 */
//@Configuration
public class RabbitConfig {
    //创建队列
    @Bean
    public Queue createQueue(){
        return new Queue("qname_money");
    }

    //演示work模式 一个队列对应多个生产者
    @Bean
    public Queue createQueue1(){
        return new Queue("qname_work_money");
    }
}

