package com.denis.zhong.world.util.thead;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomizedThreadPool {

    private static Long ALIVE_TIME_THREAD = 10L;

    private CustomizedThreadPool() {

    }

    public static Executor initTheadPool(String name){
      int cpuCount =  Runtime.getRuntime().availableProcessors();

      return new ThreadPoolExecutor(cpuCount,cpuCount*2,ALIVE_TIME_THREAD, TimeUnit.SECONDS,
              new LinkedBlockingQueue<>(),new NamedThreadFactory(name),
              new CustomRejectedHandler(name));
    }

}
