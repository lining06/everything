/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lining.springboot.mybatis;

import com.lining.springboot.everything.service.HelloService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author lining
 * @version $Id: MapperFactory.java, v 0.1 2019-09-12 5:21 PM lining Exp $
 */
public class MapperFactory {

    //配置文件
    private static final String resource = "mybatis/mybatis-config.xml";

    static Logger logger = LoggerFactory.getLogger(HelloService.class);

    private static final boolean autoCommit = Boolean.TRUE;

    //初始化 资源和sqlSessionFactory
    private static SqlSessionFactory getStream(){

        try {
            return new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
        } catch (IOException e) {
            logger.error("getStream err ", e);
            return null;
        }
    }

    private static SqlSession getSqlSession() {

        try {
            SqlSessionFactory sqlSessionFactory = getStream();

            return sqlSessionFactory.openSession(autoCommit);
        } catch (Exception e) {
            logger.error("getSqlSession err ", e);
            return null;
        }

    }

    public static Object getMapper(Class mapperClass){
        SqlSession sqlSession = null;
        try {
            //获取session
            sqlSession = getSqlSession();

            //第一种方法
            Object mapper = sqlSession.getMapper(mapperClass);
            return mapper;
        } catch (Exception e) {
            logger.error("getMapper err ", e);
            return null;
        }
    }
}