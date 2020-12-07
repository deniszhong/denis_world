package com.denis.zhong.world.service.cache.user.impl;

import com.alibaba.fastjson.JSONObject;
import com.denis.zhong.world.dao.UserDao;
import com.denis.zhong.world.entity.User;
import com.denis.zhong.world.service.cache.CacheKeyConstant;
import com.denis.zhong.world.service.cache.user.IUserCacheService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserCacheServiceImpl implements IUserCacheService {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private UserDao userDao;

    @Override
    public User getUserInfoFromCache(Integer userId) {
        String key = String.format(CacheKeyConstant.USER_INFO_CACHE_KEY, userId);
        JSONObject jsonObject = (JSONObject) redisTemplate.opsForValue().get(key);
        User user = null;
        if (Objects.nonNull(jsonObject)) {
            user = jsonObject.toJavaObject(User.class);
        } else {
            user = userDao.queryById(userId);
            redisTemplate.opsForValue().set(key, user);
        }
        return user;

    }
}
