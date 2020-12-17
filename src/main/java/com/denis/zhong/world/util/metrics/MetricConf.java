package com.denis.zhong.world.util.metrics;

import com.codahale.metrics.*;
import io.micrometer.core.instrument.Gauge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class MetricConf {

    /**
     * 度量指标 注册容器
     * @return
     */
    @Bean
    public MetricRegistry initMetricRegistry(){
        MetricRegistry registry = new MetricRegistry();
        return registry;
    }


    @Bean
    public Metric initMetric(MetricRegistry registry){
     return   registry.meter("request");
    }

    @Bean
    public Slf4jReporter initReporter(MetricRegistry registry){
        Slf4jReporter reporter =  Slf4jReporter.forRegistry(registry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertRatesTo(TimeUnit.MILLISECONDS)
                .outputTo(LoggerFactory.getLogger("com.denis.zhong.world"))
                .build();
        reporter.start(10,TimeUnit.SECONDS);
        return reporter;
    }


    @Bean
    public Histogram initHistogram(MetricRegistry registry){
      return  registry.histogram("response-size");
    }


}
