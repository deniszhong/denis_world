package com.denis.zhong.world.util.help.design.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxyObjUtils {

    public static <T> T createProxyObj(Class<T> cls, InvocationHandler handler){
        if(cls.isInterface()){
            throw new RuntimeException("不是接口");
        }
      return  (T) Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(),
                handler);

    }
}
