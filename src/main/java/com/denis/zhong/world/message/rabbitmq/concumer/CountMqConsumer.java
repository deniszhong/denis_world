package com.denis.zhong.world.message.rabbitmq.concumer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CountMqConsumer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "count_queue",durable = "true"),
            exchange = @Exchange(value="message_direct_exchange"),
            key = {"count_routing_key"})
    )
    public void onMessage(@Payload byte[] msg){
        String str = new String(msg);
        System.out.println("消息接受："+str) ;
    }
}
