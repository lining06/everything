package com.lining.springboot.everything.hello;

import com.lining.springboot.everything.service.HelloService;
import com.lining.springboot.mybatis.entity.HelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final HelloService helloService = new HelloService();

    Logger logger = LoggerFactory.getLogger(GreetingController.class);
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("greet")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        logger.info("name is " + name);
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("inserthello")
    public void insertHello(@RequestParam(value = "name") String name){
        logger.info("HelloService name is " + name);
        helloService.insertHello(name);
    }

    @RequestMapping("data")
    public List<HelloWorld> queryData() {
        return helloService.queryAllHello();
    }

}
