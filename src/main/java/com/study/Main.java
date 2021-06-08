package com.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAspectJAutoProxy
@EnableAsync
@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(Main.class);

        new SpringApplicationBuilder()
                .listeners(new ApplicationListener<ApplicationEvent>() {
                    @Override
                    public void onApplicationEvent(ApplicationEvent applicationEvent) {
                        log.info("#### >" + applicationEvent.getClass().getCanonicalName() + applicationEvent.toString());
                    }
                })
                .bannerMode(Banner.Mode.OFF)
                .sources(Main.class)
                //.web(false)  //exclude
                .run(args);
    }
}