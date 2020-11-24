package com.denis.zhong.world.util.help.design.singleton;


/***
 * 饿汉模式
 * 启动时加载 线程绝对安全
 * 启动加载，浪费内存
 */
public class HungrySingleton {

    private static HungrySingleton singleton;

    static {
        singleton = new HungrySingleton();
    }

    private HungrySingleton(){};

    public HungrySingleton getHungrySingle(){
        return singleton;
    }
}
