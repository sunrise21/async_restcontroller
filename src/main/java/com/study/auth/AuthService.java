package com.study.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    Logger log = LoggerFactory.getLogger(AuthService.class);

    public void process() {
        log.info("(test1-1) success auth check");


        throw new RuntimeException();
    }
}
