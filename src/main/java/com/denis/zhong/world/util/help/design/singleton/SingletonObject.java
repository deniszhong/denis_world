package com.denis.zhong.world.util.help.design.singleton;

public class SingletonObject {

    private static volatile SingletonObject singletonObject;

    private static Object obj = new Object();

    private SingletonObject(){

    }

    public static SingletonObject getSingletonObjectInstance(){
        if(singletonObject == null){
            synchronized (obj){
                if(singletonObject == null){
                    singletonObject = new SingletonObject();
                }
            }
        }
        return singletonObject;
    }
}
