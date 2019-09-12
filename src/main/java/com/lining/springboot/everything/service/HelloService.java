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

    public void insertHello(String name){
        logger.info("insertHello name is " + name);

        //插入数据
        helloDAO.insertHello(name);

    }

    public List<HelloWorld> queryAllHello() {
        List<HelloWorld> helloWorlds = helloDAO.queryAllHello();
        logger.info("queryAllHello " + JSON.toJSONString(helloWorlds));
        return helloWorlds;
    }
}