package com.denis.zhong.world.util.help.design.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * (1)单例模式可以保证内存里只有一个实例，减少了内存的开销。
 * （2）可以避免对资源的多重占用。
 * （3）单例模式设置全局访问点，可以优化和共享资源的访问。
 */
public class Client {

    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(1);
//        for(int i =0;i<100;i++){
//            new Thread(()->{
//                System.out.println(SingletonObject.getSingletonObjectInstance());
//            }).start();
//        }
        latch.await();
    }
}
