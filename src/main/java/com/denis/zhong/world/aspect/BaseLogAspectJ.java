package com.denis.zhong.world.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 请求入口及返回日志切面
 * 要求入参请求、返回类中重写toString类
 * 使用RequestMappering
 */
@Component
@Aspect
@Slf4j
public class BaseLogAspectJ {

    @Pointcut()
    public void logCutPoint(){

    }

    @Around("@annotation(requestMapping)")
    public Object around(ProceedingJoinPoint point, RequestMapping requestMapping) throws Throwable{
        Object[] args = point.getArgs();
        log.info("value:{}",requestMapping.value());
        if(args.length > 0){
            for(Object obj : args){
                log.info("请求入参:{}",obj.toString());
            }
        }
        Object result = point.proceed();
        //
        log.info("返回结果：{}",result.toString());
        return result;
    }
}
