package com.denis.zhong.world.util.http;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HttpUtilTest {

    @Test
    public void testGet(){
        //返回的是页面的html 语言 不能转化json
     String str =   HttpUtil.get(null,null,"http://www.baidu.com",null);
//        System.out.println(str);
    }

    @Test
    public void testPost(){

    }

}