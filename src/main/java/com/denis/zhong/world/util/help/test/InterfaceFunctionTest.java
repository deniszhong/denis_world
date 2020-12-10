package com.denis.zhong.world.util.help.test;

import com.alibaba.fastjson.JSON;
import com.denis.zhong.world.entity.User;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceFunctionTest {

    public static void main(String[] args) {
        User toUser = new User();
        toUser.setUserName("11");
        Function<User, String> function = new Function<User, String>() {
            @Override
            public String apply(User user) {
                return user.getUserName();
            }
        };
        String userName = function.apply(toUser);
        System.out.println(userName);
        Predicate pre = new Predicate<String>(){
            @Override
            public boolean test(String str) {
                return "12".equals(str);
            }

        };
        if(pre.test("12")){
            System.out.println("1111");
        }

        Supplier supplier = new Supplier<User>(){
            @Override
            public User get() {
                User user = new User();
                user.setUserName("zzf");
                return user;
            }
        };
        System.out.println(JSON.toJSONString(supplier.get()));

        List<String> list = Arrays.asList("1","2","3");
        Consumer<String> consumer = x-> System.out.println(x);
        for (String str: list) {
            consumer.accept(str);
        }
    }
}
