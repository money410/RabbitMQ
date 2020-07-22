package com.money.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 17:26
 */
//@Configuration
public class RabbitTopicConfig {
    @Bean
    public Queue createQ1(){
        return new Queue("qname_topic_money01");
    }
    @Bean
    public Queue createQ2(){
        return new Queue("qname_topic_money02");
    }

    @Bean
    public TopicExchange creatEx(){
        return new TopicExchange("ex-topic-money",true,true);
    }

//    @Bean
//    public Binding creatB1(TopicExchange fx){
//        return BindingBuilder.bind(createQ1()).to(fx).with("log.#");
//    }
//
//    @Bean
//    public Binding creatB2(TopicExchange fx){
//        return BindingBuilder.bind(createQ2()).to(fx).with("stu.*");
//    }
}
