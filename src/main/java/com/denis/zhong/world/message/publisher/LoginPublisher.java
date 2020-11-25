package com.denis.zhong.world.message.publisher;

import com.denis.zhong.world.entity.User;
import com.denis.zhong.world.message.event.LoginEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class LoginPublisher  {


    @Resource
    private ApplicationEventPublisher publisher;

    public void sendMsg(User user){
        publisher.publishEvent(new LoginEvent(this,user));
        log.info("消息异步测试。。。");
    }
}
