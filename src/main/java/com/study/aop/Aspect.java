package com.study.aop;

import com.study.auth.AuthService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;

@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Autowired
    AuthService authService;

    Logger log = LoggerFactory.getLogger(Aspect.class);

    @Around("execution(* com.study.*.*Controller.*(..)) && execution(public * *(..))")
    public Object process(final ProceedingJoinPoint joinPoint) throws Throwable {

        long begin = System.currentTimeMillis();

        log.info("(test aop)0 = {}", Thread.currentThread().getName());

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        request.setCharacterEncoding("euc-kr");

        String message = "data_00213123";

        Object object = null;

        try {
            try {
                authService.process();
                request.setAttribute("var", message);

            } catch (Exception e) {
                throw e;
            } finally {
                log.info("(test aop)1 = {}", Thread.currentThread().getName());
            }

            object = joinPoint.proceed();
            return object;

        } catch (Exception e) {
            if (!isCompletableFuture(object)) {
                log.info("(test aop)2 = {}", Thread.currentThread().getName());
                object = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            }
            return object;

        } finally {

            // i want to know respond time.
            long end = System.currentTimeMillis() - begin;
            log.info("(test aop)3 = {}", Thread.currentThread().getName());

            /** version 1 */
            if (!isCompletableFuture(object)) {
                //if object is not completableFuture object...
                log.info("(test aop)4 = {}, elapsed = {} ms", Thread.currentThread().getName(), end);
            } else {
                //if object is CompletableFuture<ResponseEntity<String>>
                CompletableFuture<?> obj = ((CompletableFuture<?>) object);
                obj.handle((msg, exception) -> {
                    if (exception != null) {
                        //if exists error, i want to return internal_error.
                        log.error("(test aop)5 = {}, elapsed = {} ms", Thread.currentThread().getName(), end);
                        return ResponseEntity.status(400).body("sunsh error");

                    } else {
                        //if success, i want to return http_status_code, body of completableFuture.
                        log.info("(test aop)6 = {}, elapsed = {} ms", Thread.currentThread().getName(), end);
                        ((CompletableFuture<?>) msg).thenApply(ret -> {

                            ResponseEntity<String> responseEntity = (ResponseEntity<String>) ret;

                            log.info("(test aop)7 = {}, elapsed = {} ms", Thread.currentThread().getName(), end);
                            return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
                        });
                    }
                    return null;
                });
            }
            log.info("(test aop)8 = {}, elapsed = {} ms", Thread.currentThread().getName(), end);
        }
    }

    private boolean isCompletableFuture(Object result) {
        return CompletableFuture.class.isAssignableFrom(result.getClass());
    }

}