package com.denis.zhong.world.message.listener;

import com.denis.zhong.world.entity.User;
import com.denis.zhong.world.message.event.LoginEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableAsync
public class LoginListener implements ApplicationListener<LoginEvent> {

    @Override
    @Async
    public void onApplicationEvent(LoginEvent event) {
        log.info("事件处理开始");
         User user = event.getUser();
        System.out.println("事件处理完成："+user.toString());
//        try {
//            Thread.sleep(5000);
//            log.info("开启消息监听异步测试");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
