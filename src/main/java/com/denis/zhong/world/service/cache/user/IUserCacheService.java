package com.denis.zhong.world.service.cache.user;

import com.denis.zhong.world.entity.User;

public interface IUserCacheService {

     User getUserInfoFromCache(Integer userId);
}
