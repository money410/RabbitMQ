package com.money.headers;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rabbitmqmoney
 * @description:
 * @author: money
 * @create: 2020-07-21 21:58
 */
//@Configuration
public class HeadersConfig {
    @Bean
    public Queue createQ1(){
        return new Queue("qname_headers_money01");
    }

    @Bean
    public Queue createQ2(){
        return new Queue("qname_headers_money02");
    }
    @Bean
    public HeadersExchange createEx(){
        return new HeadersExchange("ex_headers_money",true,true);
    }

//    @Bean
//    public Binding createB1(HeadersExchange fx){
//        return BindingBuilder.bind(createQ1()).to(fx).whereAll("token","ver").exist();
//    }
//
//    @Bean
//    public Binding createB2(HeadersExchange fx){
//        return BindingBuilder.bind(createQ2()).to(fx).whereAll("version","author").exist();
//    }

}
