package com.denis.zhong.world.controller;

import com.alibaba.fastjson.JSON;
import com.denis.zhong.world.common.BaseTest;
import com.denis.zhong.world.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.concurrent.CountDownLatch;


class UserControllerTest extends BaseTest {

    @Test
    void login() throws Exception{
        CountDownLatch latch = new CountDownLatch(1);
        User user = new User();
        user.setDeleted(0);
        user.setUserName("zzf");
        user.setPassword("123455");
        user.setRoleId(1);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(user));
        ResultActions actions = this.mockMvc.perform(requestBuilder);
        MockHttpServletResponse response = actions.andReturn().getResponse();
        System.out.println(JSON.toJSONString(response));
        latch.await();
    }
}