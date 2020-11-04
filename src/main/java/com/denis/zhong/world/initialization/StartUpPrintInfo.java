package com.denis.zhong.world.initialization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Enumeration;
import java.util.Properties;


@Order
@Service
public class StartUpPrintInfo implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(StartUpPrintInfo.class);

    @Override
    public void run(String... args) throws Exception {
      Properties props = System.getProperties();

        Enumeration enums =  props.keys();
        while(enums.hasMoreElements()){
          String key =  enums.nextElement().toString();
          logger.info("key:{},value:{}",key,props.get(key));
        }
    }
}
