package com.denis.zhong.world.message.rabbitmq.asyn;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Slf4j
public class CustomizedReturnCallBack implements RabbitTemplate.ReturnCallback {

    //实现ReturnCallback接口，如果消息从交换器发送到对应队列失败时触发
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange,
                                String routingKey) {
        log.info(JSON.toJSONString(message)+"|| routingkey:{}",routingKey);
    }
}
