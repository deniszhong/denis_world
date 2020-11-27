package com.denis.zhong.world.message.rabbitmq.publisher;

import com.denis.zhong.world.entity.User;
import com.denis.zhong.world.service.bo.CountMqBO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SendMsgPublisher {


    @Resource
    private RabbitTemplate rabbitTemplate;

    public void  sendMq(User user){
        rabbitTemplate.convertAndSend("message_direct_exchange","message_routing_key",user);
    }

    public void countMq(CountMqBO countMqBO){
        rabbitTemplate.convertAndSend("message_direct_exchange","count_routing_key",countMqBO);
    }
}
