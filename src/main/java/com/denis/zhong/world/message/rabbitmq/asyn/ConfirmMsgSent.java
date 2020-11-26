package com.denis.zhong.world.message.rabbitmq.asyn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Slf4j
public class ConfirmMsgSent implements RabbitTemplate.ReturnCallback {

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("replayCode:{},replyText:{},exchange:{},routingKey:{}",replyCode,replyText,exchange,routingKey);
    }
}
