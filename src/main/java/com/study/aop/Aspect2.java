

package com.study.aop;

import com.study.auth.AuthService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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

//@Component
//@org.aspectj.lang.annotation.Aspect
public class Aspect2 {
//
//    @Autowired
//    AuthService authService;
//
//    Logger log = LoggerFactory.getLogger(Aspect2.class);
//
//    //@Around("execution(* com.study.*.*Controller.*(..)) && execution(public * *(..))")
//    public Object process(final ProceedingJoinPoint joinPoint) throws Throwable {
//
//        long begin = System.currentTimeMillis();
//
//        log.info("(test aop)0 = {}", Thread.currentThread().getName());
//
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//
//        request.setCharacterEncoding("euc-kr");
//
//        String message = "data_00213123";
//
//        Object object = null;
//
//        try {
//            try {
//                authService.process();
//                request.setAttribute("var", message);
//
//            } catch (Exception e) {
//                throw e;
//            } finally {
//                //todo 통계 트레이스 request
//                log.info("(test aop) try 1 = {}", Thread.currentThread().getName());
//            }
//
//
//            /**** */
//            object = (CompletableFuture<?>) joinPoint.proceed();
//            /**** */
//
//
//            log.info("(test aop) try proceed = {}", object.toString());  //java.util.concurrent.CompletableFuture@7c43e5cd[Not completed]
//            return object;
//        } catch (Exception e) {
//
//            log.info("\"(test aop)2 catch sunsh exception1 = {}", e.toString());
//
//            if (!isCompletableFuture(object)) {
//                log.info("(test aop)2-1 catch no !isCompletableFuture = {}", Thread.currentThread().getName());
//                object = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(HttpStatus.BAD_REQUEST.getReasonPhrase());
//            } else {
//                log.info("(test aop)2-1 catch ok isCompletableFuture = {}", Thread.currentThread().getName());
//                object = CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(HttpStatus.BAD_REQUEST.getReasonPhrase()));
//            }
//            return object;
//
//        } finally {
//
//            // i want to know respond time.
//            long end = System.currentTimeMillis() - begin;
//            log.info("(test aop) finally 3 = {}", Thread.currentThread().getName());
//
//            log.info("(test aop) finanly 4 = {}, {}",             ((CompletableFuture<?>) object).isDone(), ((CompletableFuture<?>) object).isCompletedExceptionally());
//
///*
//            if (!isCompletableFuture(object)) {
//                //if object is not completableFuture object...
//                log.info("(test aop)4 finally - if = {}, elapsed = {} ms, object ={}", Thread.currentThread().getName(), end, object.toString());
////                return object;
//            }
//
//            return ((CompletableFuture<?>) object).whenComplete((o, throwable) -> {
//                if (null != throwable) {
//                    log.error("(test aop) 77 = {}", throwable.getMessage(), throwable);
//                }
//                if (null != o) {
//                    log.info("(test aop) 77-1 = {}", o.toString());
//                }
//            });
//
// */
//        }
//            //if object is CompletableFuture<ResponseEntity<String>>
//
//            /*** v2
//             return ((CompletableFuture<?>) object).thenApply(k -> {
//             log.info("(test aop) finally - else 99 = {}", k.toString());
//             if(k instanceof ResponseEntity){
//             log.info("(test aop) finally - else 99-0 = {} is ResponseEntity object");
//             }
//             return k;
//             }).exceptionally(ex-> { //Throwable
//             if(ex instanceof Exception){
//             log.info("(test aop) finally - else - exceptionally - ex instanceof Exception 99-1 = {}", ex.toString());
//             //                    ResponseEntity.status(407).body("sunsh");
//             }
//             //에러
//             //java.util.concurrent.CompletableFuture@63dfb2d9[Completed exceptionally]
//             //java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
//             }).thenApply(nk -> {
//
//             log.info("(test aop) finally - else - exceptionally - ex instanceof Exception 99-3= {}", nk.toString());
//             return CompletableFuture.completedFuture(ResponseEntity.status(407).body("sfd"));
//             });
//             */
//        /**
//         CompletableFuture<?> obj = ((CompletableFuture<?>) object);
//         obj.handle((msg, exception) -> {
//         if (exception != null) {
//         //if exists error, i want to return internal_error.
//         log.error("(test aop)5 = {}, elapsed = {} ms", Thread.currentThread().getName(), end);
//         return ResponseEntity.status(400).body("sunsh error");
//
//         } else {
//         //if success, i want to return http_status_code, body of completableFuture.
//         log.info("(test aop)6 = {}, elapsed = {} ms", Thread.currentThread().getName(), end);
//         ((CompletableFuture<?>) msg).thenApply(ret -> {
//
//         ResponseEntity<String> responseEntity = (ResponseEntity<String>) ret;
//
//         log.info("(test aop)7 = {}, elapsed = {} ms", Thread.currentThread().getName(), end);
//         //return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
//         return null;
//         });
//         }
//         return null;
//         });
//         */
////            log.info("(test aop)8 finally = {}, elapsed = {} ms", Thread.currentThread().getName(), end);
////        }
////        log.info("(test aop) last = {}", Thread.currentThread().getName());
////        return null; //null을 보내면 200ok 됨
////        return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("SUNSH"));
//    }
//
//    private boolean isCompletableFuture(Object result) {
//        return CompletableFuture.class.isAssignableFrom(result.getClass());
//    }

}