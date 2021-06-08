# async_restcontroller


<b>1) tomcat thread : http reqeust -> http-nio-8080-exec-1</b>
<br>
[2021-06-09 00:14:44.246][DEBUG] {<b>http-nio-8080-exec-1</b>} GET "/service", parameters={} <br>
[2021-06-09 00:14:44.246][DEBUG] {http-nio-8080-exec-1} Mapped to com.study.service.Controller#createClickCall(HttpServletRequest) <br>
[2021-06-09 00:14:44.246][INFO ] {http-nio-8080-exec-1} (test aop)0 = http-nio-8080-exec-1 <br>
[2021-06-09 00:14:44.246][INFO ] {http-nio-8080-exec-1} (test1-1) success auth check <br>
[2021-06-09 00:14:44.246][INFO ] {http-nio-8080-exec-1} (test aop)1 = http-nio-8080-exec-1 <br>
[2021-06-09 00:14:44.246][INFO ] {http-nio-8080-exec-1} (test aop)3 = http-nio-8080-exec-1 <br>
[2021-06-09 00:14:44.246][INFO ] {http-nio-8080-exec-1} (test aop)8 = http-nio-8080-exec-1, elapsed = 0 ms <br>
<br>
<b>2) completableFuture thread : pool-2-thread-</b>
<br>
[2021-06-09 00:14:44.246][INFO ] {<b>pool-2-thread-1</b>} (test controller)22 async thread = pool-2-thread-1 <br>
[2021-06-09 00:14:44.246][INFO ] {pool-2-thread-1} (test controller) 22-1 async v1 = data_00213123 <br>
[2021-06-09 00:14:44.246][INFO ] {pool-2-thread-1} (test)var = data_00213123, isService = true <br>
[2021-06-09 00:14:44.246][DEBUG] {http-nio-8080-exec-1} Started async request <br>
[2021-06-09 00:14:44.246][DEBUG] {http-nio-8080-exec-1} Exiting but response remains open for further handling <br>
[2021-06-09 00:14:44.247][DEBUG] {pool-2-thread-1} Async result set, dispatch to /service <br>
[2021-06-09 00:14:44.247][INFO ] {http-nio-8080-exec-1} #### >org.springframework.web.context.support.ServletRequestHandledEventServletRequestHandledEvent: url=[/service]; client=[0:0:0:0:0:0:0:1]; method=[GET]; servlet=[dispatcherServlet]; session=[null]; user=[null]; time=[1ms]; status=[OK] <br>
[2021-06-09 00:14:44.247][INFO ] {pool-2-thread-1} (test aop)6 = pool-2-thread-1, elapsed = 0 ms <br>
 <br>
<b>3) tomcat thread : async, http response -> http-nio-8080-exec-2</b>
<br>
[2021-06-09 00:14:44.247][DEBUG] {<b>http-nio-8080-exec-2</b>} "ASYNC" dispatch for GET "/service", parameters={} <br>
[2021-06-09 00:14:44.248][DEBUG] {http-nio-8080-exec-2} Resume with async result [<201,created,[]>] <br>
[2021-06-09 00:14:44.248][DEBUG] {http-nio-8080-exec-2} Using 'text/html', given [text/html, application/xhtml+xml, image/avif, image/webp, image/apng, application/xml;q=0.9, application/signed-exchange;v=b3;q=0.9, */*;q=0.8] and supported [text/plain, */*, text/plain, */*, application/json, application/*+json, application/json, application/*+json] <br>
[2021-06-09 00:14:44.248][DEBUG] {http-nio-8080-exec-2} Writing ["created"] <br>
[2021-06-09 00:14:44.249][DEBUG] {http-nio-8080-exec-2} Exiting from "ASYNC" dispatch, status 201 <br>
[2021-06-09 00:14:44.249][INFO ] {http-nio-8080-exec-2} #### >org.springframework.web.context.support.ServletRequestHandledEventServletRequestHandledEvent: url=[/service]; client=[0:0:0:0:0:0:0:1]; method=[GET]; servlet=[dispatcherServlet]; session=[null]; user=[null]; time=[2ms]; status=[OK] <br>
 <br>
