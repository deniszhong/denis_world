package com.denis.zhong.world.util.help.design.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RechargeProxy implements InvocationHandler {

    private IRealProvider realProvider;

    public RechargeProxy(IRealProvider realProvider) {
        this.realProvider = realProvider;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("pre-增强");
        //调用目标类
        Object result =  method.invoke(realProvider,args);
        System.out.println("after-增强");
      return result;
    }
}
