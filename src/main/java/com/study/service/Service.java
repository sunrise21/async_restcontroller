package com.study.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Service {

    Logger log = LoggerFactory.getLogger(Service.class);

    public void serviceLogic(String var, boolean isService) {

        log.info("(test)var = {}, isService = {}", var, isService);
        //service logic end
    }
}
