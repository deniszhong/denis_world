package com.denis.zhong.world.message.rabbitmq.conf;

import com.denis.zhong.world.message.rabbitmq.asyn.ConfirmMsgSent;
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
    public Queue createQueue(){
        return new Queue("message_queue",true);
    }

    @Bean(name="messageExchange")
    public Exchange declareExchange(){
        return new TopicExchange("message_topic_exchange",true,false);

    }


    @Bean
    public Binding createBinding(){
        return BindingBuilder
                .bind(createQueue())
                .to(declareExchange())
                .with("message_routing_key")
                .noargs();
    }


    @Bean
    public RabbitTemplate rabbitTemplate(RabbitProperties properties){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(new ConfirmMsgSent());
        rabbitTemplate.setConnectionFactory(connectionFactory(properties));
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
