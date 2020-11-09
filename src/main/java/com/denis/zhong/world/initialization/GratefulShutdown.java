package com.denis.zhong.world.initialization;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GratefulShutdown implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {

    private volatile Connector connector;

    @Override
    public void customize(Connector connector) {
        this.connector = connector;
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        //Connector：用于接收请求并将请求封装成Request和Response来进行具体的处理，最底层使用socket来进行连接
        //Connector中具体使用ProtocolHandler来处理请求，不同的ProtocolHandler代表不同的连接类型。
        // 例如，Http1Protocol使用普通的Socket连接，而Http1BioProtocol则使用NioSocket来连接
        Executor executor = this.connector.getProtocolHandler().getExecutor();
        if(executor instanceof ThreadPoolExecutor){
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
            //不再接受新的线程，并且等待之前提交的线程都执行完后，再关闭
            threadPoolExecutor.shutdown();
            try {
                if(threadPoolExecutor.awaitTermination(15, TimeUnit.SECONDS)){
                    log.warn("tomcat thread pool did not shut down grateful within 15sec");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
