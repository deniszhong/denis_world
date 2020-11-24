package com.denis.zhong.world.util.help.design.proxy;

import com.denis.zhong.world.util.help.design.proxy.cglib.CglibProxyCreateUtil;
import com.denis.zhong.world.util.help.design.proxy.cglib.RechargeInterceptor;
import com.denis.zhong.world.util.help.design.proxy.jdk.IRealProvider;
import com.denis.zhong.world.util.help.design.proxy.jdk.JDKProxyObjUtils;
import com.denis.zhong.world.util.help.design.proxy.jdk.RechargeProxy;
import com.denis.zhong.world.util.help.design.proxy.jdk.ZZFStatProxy;

public class client {

    /***
     * （1）JDK动态代理实现了被代理对象的接口，CGLib动态代理继承了被代理对象。
     * （2）JDK动态代理和CGLib动态代理都在运行期生成字节码，JDK动态代理直接写Class字节码，
     * CGLib动态代理使用ASM框架写Class字节码。CGLib动态代理实现更复杂，生成代理类比JDK动态代理效率低。
     * （3）JDK动态代理调用代理方法是通过反射机制调用的，CGLib动态代理是通过FastClass机制直接调用方法的，
     * CGLib动态代理的执行效率更高
     * @param args
     */
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
