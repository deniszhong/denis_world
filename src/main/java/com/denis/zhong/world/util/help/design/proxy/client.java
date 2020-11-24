package com.denis.zhong.world.util.help.design.proxy;

import com.denis.zhong.world.util.help.design.proxy.cglib.CglibProxyCreateUtil;
import com.denis.zhong.world.util.help.design.proxy.cglib.RechargeInterceptor;
import com.denis.zhong.world.util.help.design.proxy.jdk.IRealProvider;
import com.denis.zhong.world.util.help.design.proxy.jdk.JDKProxyObjUtils;
import com.denis.zhong.world.util.help.design.proxy.jdk.RechargeProxy;
import com.denis.zhong.world.util.help.design.proxy.jdk.ZZFStatProxy;

public class client {

    public static void main(String[] args) {
        client.testCgLib();
//        client.testJDK();
    }

    private static void testCgLib(){
        ZZFStatProxy  enhancer = CglibProxyCreateUtil.CglibProxyGeneratory(ZZFStatProxy.class,
                new RechargeInterceptor());
        enhancer.recharge();

    }

    private static void testJDK(){
        IRealProvider provider = new ZZFStatProxy();
        IRealProvider stat = JDKProxyObjUtils.createProxyObj(provider.getClass(), new RechargeProxy(provider));
        stat.recharge();
    }
}
