package com.denis.zhong.world.util.help.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.function.BiConsumer;

public class CompletableFutureTest {
    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(1);
        CompletableFuture future = new CompletableFuture();

        future.thenRunAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1");
            }
        });
        future.complete("OK");
        System.out.println(future.get());
        System.out.println("1111");

        future.whenComplete(new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                System.out.println("2222");
                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        latch.await();
    }
}
