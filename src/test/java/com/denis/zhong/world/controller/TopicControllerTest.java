package com.denis.zhong.world.controller;

import com.alibaba.fastjson.JSON;
import com.denis.zhong.world.common.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

class TopicControllerTest extends BaseTest {

    @Test
    public void selectOne() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/topic/selectOne/1")
                .contentType(MediaType.APPLICATION_JSON);
        ResultActions actions = this.mockMvc.perform(requestBuilder);
        MockHttpServletResponse response = actions.andReturn().getResponse();
        System.out.println(JSON.toJSONString(response));
    }
}