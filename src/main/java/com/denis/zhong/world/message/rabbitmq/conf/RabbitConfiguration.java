package com.denis.zhong.world.message.rabbitmq.conf;

import com.denis.zhong.world.message.rabbitmq.asyn.ConfirmMsgSent;
import com.denis.zhong.world.message.rabbitmq.asyn.CustomizedReturnCallBack;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {


    @Bean(name = "messageQueue")
    public Queue createMsgQueue(){
        return new Queue("message_queue",true);
    }

    @Bean(name="countQueue")
    public Queue createCountQueue(){
        return new Queue("count_queue");
    }

    @Bean(name="directExchange")
    public Exchange declareDirectExchange(){
        return new DirectExchange("message_direct_exchange",true,false);
    }

//    @Bean(name="topicExchange")
//    public Exchange declareTopicExchange(){
//        return new TopicExchange("message_topic_exchange",true,false);
//
//    }


    @Bean
    public Binding createMessageBinding(){
        return BindingBuilder
                .bind(createMsgQueue())
                .to(declareDirectExchange())
                .with("message_routing_key")
                .noargs();
    }

    @Bean
    public Binding createCountBinding(){
        return BindingBuilder
                .bind(createCountQueue())
                .to(declareDirectExchange())
                .with("count_routing_key")
                .noargs();
    }


    @Bean
    public RabbitTemplate rabbitTemplate(RabbitProperties properties){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(new CustomizedReturnCallBack());
        rabbitTemplate.setConnectionFactory(connectionFactory(properties));
        rabbitTemplate.setConfirmCallback(new ConfirmMsgSent());
        return rabbitTemplate;
    }

    @Bean
    public ConnectionFactory connectionFactory(RabbitProperties properties){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CONNECTION);
        connectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.SIMPLE);
        connectionFactory.setPublisherReturns(true);
        connectionFactory.setHost(properties.getHost());
        connectionFactory.setPort(properties.getPort());
        connectionFactory.setVirtualHost(properties.getVirtualHost());
        return connectionFactory;
    }

}
