/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lining.springboot.everything.service;

import com.alibaba.fastjson.JSON;
import com.lining.springboot.mybatis.MapperFactory;
import com.lining.springboot.mybatis.entity.HelloWorld;
import com.lining.springboot.mybatis.interfaces.HelloDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * @author lining
 * @version $Id: HelloService.java, v 0.1 2019-09-12 5:38 PM lining Exp $
 */

public class HelloService {

    Logger logger = LoggerFactory.getLogger(HelloService.class);

    //拿到mapper
    private HelloDAO helloDAO = (HelloDAO)MapperFactory.getMapper(HelloDAO.class);

    //插入数据
    public void insertHello(String name){
        logger.info("insertHello name is " + name);

        helloDAO.insertHello(name);
    }

    //查全量数据
    public List<HelloWorld> queryAllHello() {
        List<HelloWorld> helloWorlds = helloDAO.queryAllHello();
        logger.info("queryAllHello " + JSON.toJSONString(helloWorlds));
        return helloWorlds;
    }

    //根据id查
    public HelloWorld selectById(long id){
        return helloDAO.selectHello(id);
    }
}