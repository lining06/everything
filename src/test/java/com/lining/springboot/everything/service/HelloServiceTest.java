package com.lining.springboot.everything.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {

	private static final HelloService helloService = new HelloService();

	Logger logger = LoggerFactory.getLogger(HelloServiceTest.class);
	@Test
	public void testInsertHello(){
		helloService.insertHello("数据");
	}

	@Test
	public void testQueryAll(){
		logger.info("result", helloService.queryAllHello());

	}
}
