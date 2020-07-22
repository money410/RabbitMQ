package com.money.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 13:35
 */
//@Configuration
public class RabbitFanoutConfig {
    //2个队列
    //@Bean
    public Queue createQ1(){
        return new Queue("qname_fanout1_money");
    }
    //@Bean
    public Queue createQ2(){
        return new Queue("qname_fanout2_money");
    }
    //一个交换器
    @Bean
    public FanoutExchange createEx(){
        return new FanoutExchange("ex_fanout_money",true,true);
    }
    //2绑定
    @Bean
    public Binding createB01(FanoutExchange fx){
        return BindingBuilder.bind(createQ1()).to(fx);
    }

    @Bean
    public Binding createB02(FanoutExchange fx){
        return BindingBuilder.bind(createQ2()).to(fx);
    }
}
