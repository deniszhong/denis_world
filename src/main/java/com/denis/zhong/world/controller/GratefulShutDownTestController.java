package com.denis.zhong.world.controller;

import com.denis.zhong.world.controller.vo.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/shutdown")
@RestController
@Slf4j
public class GratefulShutDownTestController {

    /**
     * 请求进来 之后断开应用，
     * 测试优雅关机
     * @return
     */
    @RequestMapping("/oper")
    public ResultDTO<Boolean> shutdwon(){
        log.info("enter into shut down and sleep 20sec");
        try {
            Thread.currentThread().sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("shut down grateful");
        return new ResultDTO<Boolean>();
    }
}
