//package com.denis.zhong.world.service.user.impl;
//
//import com.denis.zhong.world.dao.UserDao;
//import com.denis.zhong.world.entity.User;
//import com.denis.zhong.world.service.user.IUserService;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class UserServiceImpl implements IUserService {
//
//    @Resource
//    private UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userDao.queryByUserName(username);
//        if(Objects.nonNull(user)){
//            List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
//            authorityList.add(new SimpleGrantedAuthority(String.valueOf(user.getRoleId())));
//            UserDetails userDetails = new org.springframework.security.core.userdetails.User(username,"{noop}"+user.getPassword(),authorityList);
//            return userDetails;
//        }
//       throw  new UsernameNotFoundException("user name not found");
//    }
//}
