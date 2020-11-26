package com.denis.zhong.world.message.rabbitmq.concumer;


import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MessageListener {

    private AtomicInteger num = new AtomicInteger(0);

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "message_queue",durable = "true"),
            exchange = @Exchange(value="message_topic_exchange"),
            key = {"message_routing_key"})
            )
    public void consumeMsg(@Payload byte[] msg){
        num.addAndGet(1);
        String str = new String(msg);
        System.out.println(str+"||"+num) ;

    }
}
