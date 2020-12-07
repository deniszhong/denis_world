package com.denis.zhong.world.util.thead;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomizedThreadPoolExecutor {

    private ThreadPoolExecutor threadPoolExecutor;

    public CustomizedThreadPoolExecutor(String name) {
        int coreNum = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreNum, coreNum * 2,
                5000, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), new NamedThreadFactory(name), new CustomRejectedHandler(name));
        this.threadPoolExecutor = threadPoolExecutor;
    }
}
