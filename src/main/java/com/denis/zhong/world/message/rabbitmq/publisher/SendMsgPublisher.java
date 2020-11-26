package com.denis.zhong.world.message.rabbitmq.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SendMsgPublisher {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void  sendMq(){
        rabbitTemplate.convertAndSend("message_topic_exchange","message_routing_key","1234");
    }
}
