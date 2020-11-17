package com.denis.zhong.world.common;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
//@RunWith(SpringRunner.class) --- 被ExtendWith 替代 在SpringBootTest注解中
@WebAppConfiguration
@ComponentScan("com.denis.zhong.world")
public class BaseTest {

    @Autowired
    public WebApplicationContext webApplicationContext;

    public MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}
