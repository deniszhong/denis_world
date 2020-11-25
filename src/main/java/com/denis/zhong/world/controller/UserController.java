package com.denis.zhong.world.controller;

import com.denis.zhong.world.controller.vo.ResultDTO;
import com.denis.zhong.world.entity.User;
import com.denis.zhong.world.message.event.LoginEvent;
import com.denis.zhong.world.message.publisher.LoginPublisher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private LoginPublisher publisher;

    @RequestMapping("/login")
    public ResultDTO<User> login(@RequestBody User user){
          publisher.sendMsg(user);
        return new ResultDTO<>(user);
    }
}
