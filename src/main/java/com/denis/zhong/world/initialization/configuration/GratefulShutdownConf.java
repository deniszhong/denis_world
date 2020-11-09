package com.denis.zhong.world.initialization.configuration;

import com.denis.zhong.world.initialization.GratefulShutdown;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GratefulShutdownConf {

    @Bean
    public GratefulShutdown gratefulShutdown(){
        return new GratefulShutdown();
    }

    //注册自定义的Connector监听器
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory(final GratefulShutdown gratefulShutdown){

        TomcatServletWebServerFactory webServerFactory = new TomcatServletWebServerFactory();
        webServerFactory.addConnectorCustomizers(gratefulShutdown);
        return webServerFactory;
    }
}
