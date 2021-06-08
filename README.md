# async_restcontroller
test

[2021-06-09 00:14:44.246][DEBUG] {http-nio-8080-exec-1} GET "/service", parameters={}
[2021-06-09 00:14:44.246][DEBUG] {http-nio-8080-exec-1} Mapped to com.study.service.Controller#createClickCall(HttpServletRequest)
[2021-06-09 00:14:44.246][INFO ] {http-nio-8080-exec-1} (test aop)0 = http-nio-8080-exec-1
[2021-06-09 00:14:44.246][INFO ] {http-nio-8080-exec-1} (test1-1) success auth check
[2021-06-09 00:14:44.246][INFO ] {http-nio-8080-exec-1} (test aop)1 = http-nio-8080-exec-1
[2021-06-09 00:14:44.246][INFO ] {http-nio-8080-exec-1} (test aop)3 = http-nio-8080-exec-1
[2021-06-09 00:14:44.246][INFO ] {http-nio-8080-exec-1} (test aop)8 = http-nio-8080-exec-1, elapsed = 0 ms

[2021-06-09 00:14:44.246][INFO ] {pool-2-thread-1} (test controller)22 async thread = pool-2-thread-1
[2021-06-09 00:14:44.246][INFO ] {pool-2-thread-1} (test controller) 22-1 async v1 = data_00213123
[2021-06-09 00:14:44.246][INFO ] {pool-2-thread-1} (test)var = data_00213123, isService = true
[2021-06-09 00:14:44.246][DEBUG] {http-nio-8080-exec-1} Started async request
[2021-06-09 00:14:44.246][DEBUG] {http-nio-8080-exec-1} Exiting but response remains open for further handling
[2021-06-09 00:14:44.247][DEBUG] {pool-2-thread-1} Async result set, dispatch to /service
[2021-06-09 00:14:44.247][INFO ] {http-nio-8080-exec-1} #### >org.springframework.web.context.support.ServletRequestHandledEventServletRequestHandledEvent: url=[/service]; client=[0:0:0:0:0:0:0:1]; method=[GET]; servlet=[dispatcherServlet]; session=[null]; user=[null]; time=[1ms]; status=[OK]
[2021-06-09 00:14:44.247][INFO ] {pool-2-thread-1} (test aop)6 = pool-2-thread-1, elapsed = 0 ms

[2021-06-09 00:14:44.247][DEBUG] {http-nio-8080-exec-2} "ASYNC" dispatch for GET "/service", parameters={}
[2021-06-09 00:14:44.248][DEBUG] {http-nio-8080-exec-2} Resume with async result [<201,created,[]>]
[2021-06-09 00:14:44.248][DEBUG] {http-nio-8080-exec-2} Using 'text/html', given [text/html, application/xhtml+xml, image/avif, image/webp, image/apng, application/xml;q=0.9, application/signed-exchange;v=b3;q=0.9, */*;q=0.8] and supported [text/plain, */*, text/plain, */*, application/json, application/*+json, application/json, application/*+json]
[2021-06-09 00:14:44.248][DEBUG] {http-nio-8080-exec-2} Writing ["created"]
[2021-06-09 00:14:44.249][DEBUG] {http-nio-8080-exec-2} Exiting from "ASYNC" dispatch, status 201
[2021-06-09 00:14:44.249][INFO ] {http-nio-8080-exec-2} #### >org.springframework.web.context.support.ServletRequestHandledEventServletRequestHandledEvent: url=[/service]; client=[0:0:0:0:0:0:0:1]; method=[GET]; servlet=[dispatcherServlet]; session=[null]; user=[null]; time=[2ms]; status=[OK]
