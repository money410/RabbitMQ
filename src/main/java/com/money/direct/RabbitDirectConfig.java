package com.money.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 14:19
 */
//@Configuration
public class RabbitDirectConfig {

    @Bean
    public Queue createQ1(){
        return new Queue("qname_direct_money1");
    }

    @Bean
    public Queue createQ2(){
        return new Queue("qname_direct_money2");
    }

    @Bean
    public DirectExchange ex(){
        return new DirectExchange("ex_direct_money",true,true);
    }

//    @Bean
//    public Binding createB01(DirectExchange fx){
//        return BindingBuilder.bind(createQ1()).to(fx).with("log");
//    }
//
//    @Bean
//    public Binding createB02(DirectExchange fx){
//        return BindingBuilder.bind(createQ2()).to(fx).with("error");
//    }
}
