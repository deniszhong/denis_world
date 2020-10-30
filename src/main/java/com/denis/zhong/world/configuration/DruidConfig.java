package com.denis.zhong.world.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;


//@Configuration
public class DruidConfig {

//    @Bean
    public DataSource druid(){
        DruidDataSource dataSource = new DruidDataSource();
        try {
            dataSource.init();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return dataSource;
    }
}
