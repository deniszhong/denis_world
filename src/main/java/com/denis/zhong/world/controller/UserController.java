package com.denis.zhong.world.controller;

import com.denis.zhong.world.controller.vo.ResultDTO;
import com.denis.zhong.world.entity.User;
import com.denis.zhong.world.message.event.LoginEvent;
import com.denis.zhong.world.message.publisher.LoginPublisher;
import com.denis.zhong.world.message.rabbitmq.publisher.SendMsgPublisher;
import com.denis.zhong.world.service.cache.user.IUserCacheService;
import com.denis.zhong.world.service.cache.user.impl.UserCacheServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private LoginPublisher publisher;

    @Resource
    private SendMsgPublisher sendMsgPublisher;

    @Resource
    private IUserCacheService userCacheService;

    /**
     * 测试mq及spring监听
     *
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public ResultDTO<User> login(@RequestBody User user) {
        publisher.sendMsg(user);
        for (int i = 0; i < 1; i++) {
            sendMsgPublisher.sendMq(user);
        }
        return new ResultDTO<>(user);
    }

    @GetMapping("/get/{id}")
    public ResultDTO<User> getUserInfoById(@PathVariable("id") Integer id){
       User user =  userCacheService.getUserInfoFromCache(id);
       return new ResultDTO<>(user);
    }
}
