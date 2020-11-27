package com.denis.zhong.world.message.rabbitmq.asyn;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Slf4j
public class ConfirmMsgSent implements RabbitTemplate.ConfirmCallback {

    //确认消息发送成功，通过实现ConfirmCallBack接口，消息发送到交换器Exchange后触发回调
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {

        log.info("confirmMsg:{},ack:{},cause:{}"+ JSON.toJSONString(correlationData),
                ack,cause);
    }
}
