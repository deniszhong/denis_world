package com.denis.zhong.world.util.thead;

import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory {

    private String name;

    public NamedThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(Thread.currentThread().getThreadGroup(),r,name,0);
        t.setDaemon(false);
        return t;
    }
}
