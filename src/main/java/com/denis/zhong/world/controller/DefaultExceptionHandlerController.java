package com.denis.zhong.world.controller;

import com.denis.zhong.world.common.exception.BizException;
import com.denis.zhong.world.controller.vo.ResultDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//定义统一的异常处理类
@ControllerAdvice(basePackages = "com.denis.zhong.world")
public class DefaultExceptionHandlerController {

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public ResultDTO<String> bizExceptionHandler(HttpServletRequest request,BizException e){
        ResultDTO resultDTO =  new ResultDTO();
        resultDTO.setCode(e.getCode());
        resultDTO.setMessage(e.getMessage());
        resultDTO.setMessage(request.getRequestURI());
        return resultDTO;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultDTO<String> runtimeExceptionHandler(HttpServletRequest request,RuntimeException e){
        ResultDTO resultDTO =  new ResultDTO();
        resultDTO.setMessage(e.getMessage());
        return resultDTO;
    }
}
