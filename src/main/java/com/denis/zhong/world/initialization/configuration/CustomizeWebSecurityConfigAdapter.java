package com.denis.zhong.world.initialization.configuration;

import com.denis.zhong.world.service.user.IUserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
public class CustomizeWebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

    @Resource
    private IUserService userService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        //内存模式
//        auth.inMemoryAuthentication()
//                .withUser("zhangsan")
//                .password("{noop}123")
//                .authorities("ADMIN");
        //DB
        auth.userDetailsService(userService);

    }

    /***
     * 重定义 访问白名单 需要校验的访问
     * 登入界面
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        //这种模式 应该也不适用 分布式（集群）
        http.authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .anyRequest().authenticated(); //剩下的需要访问地址需要校验
//                .and()
//                    .formLogin()
//                    .loginPage("/login.html")
//                    .loginProcessingUrl("/login.do")
//                    .defaultSuccessUrl("/home.html")
//                    .failureForwardUrl("/error.html")
//                .and()
//                    .logout()
//                    .logoutUrl("/logout")
//                    .logoutSuccessUrl("/login.html");
                //.and().csrf().disable();
                //跨域攻击 http验证 Referer
                // 1.http验证 Referer 2.token防伪


    }
}
