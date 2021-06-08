package com.study.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class Controller{

    @Autowired
    Service service;

    ExecutorService executor = Executors.newCachedThreadPool();

    Logger log = LoggerFactory.getLogger(Controller.class);

    @GetMapping(value = "/service")
    public CompletableFuture<ResponseEntity<String>> createClickCall(HttpServletRequest request) throws Exception {

        return CompletableFuture.supplyAsync(
                () -> {
                    log.info("(test controller)22 async thread = {}", Thread.currentThread().getName());

                    String var = (String)request.getAttribute("var");
                    log.info("(test controller) 22-1 async v1 = {}", var);

                    try {
                        //call service logic
                        service.serviceLogic(var, true);
                    } catch (Exception e) {
                        log.error("(test controller)controller error", e);
                    }

                    return ResponseEntity.status(201).body("created");
                }, executor);
    }
}