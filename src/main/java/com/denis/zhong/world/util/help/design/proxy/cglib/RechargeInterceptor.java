package com.denis.zhong.world.util.help.design.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class RechargeInterceptor implements MethodInterceptor {

    /***
     *
     * @param obj 代表Cglib 生成的动态代理类 对象本身
     * @param method 代理类中被拦截的接口方法 Method 实例
     * @param objects 接口方法参数
     * @param methodProxy 用于调用父类真正的业务类方法。可以直接调用被代理类接口方法
     * @return
     * @throws Throwable
     */

    /**
     * CGLib动态代理执行代理方法的效率之所以比JDK高，是因为CGlib采用了FastClass机制，
     * 它的原理简单来说就是：为代理类和被代理类各生成一个类，
     * 这个类会为代理类或被代理类的方法分配一个index（int类型）；
     * 这个index被当作一个入参，FastClass可以直接定位要调用的方法并直接进行调用，省去了反射调用，
     * 因此调用效率比JDK动态代理通过反射调用高
     * @param obj
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("pre-增强");
        Object result =methodProxy.invokeSuper(obj,objects);
        System.out.println("after-增强");
        return result;
    }
}
