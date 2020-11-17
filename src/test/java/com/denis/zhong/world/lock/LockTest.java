package com.denis.zhong.world.lock;

import java.util.concurrent.CountDownLatch;

public class LockTest {

    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(1);

        for(int i =0 ; i < 10;i++){
            Thread t = new Thread(()->{
                LockObject lock = new LockObject("1");
                synchronized (lock.getLockKey().intern()){
                    try {
                        System.out.println(Thread.currentThread().getName()+"开始");
                        Thread.currentThread().sleep(5000);
                        System.out.println(Thread.currentThread().getName()+"结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        latch.await();
    }
}
