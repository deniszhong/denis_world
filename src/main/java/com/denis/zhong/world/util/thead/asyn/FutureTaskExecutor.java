package com.denis.zhong.world.util.thead.asyn;

import com.alibaba.fastjson.JSON;
import com.denis.zhong.world.entity.User;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExecutor {

    public static void main(String[] args) {
        FutureTask task = new FutureTask(
                new Callable<User>() {
                    @Override
                    public User call() throws Exception {
                        User user = new User();
                        user.setUserName("zzf");
                        return user;
                    }
                }
        );
        task.run();
        try {
            User user = (User) task.get();
            System.out.println(JSON.toJSONString(user));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        CompletableFuture

    }
}
