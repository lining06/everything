/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lining.springboot.mybatis.interfaces;

import com.lining.springboot.mybatis.entity.HelloWorld;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lining
 * @version $Id: HelloDAO.java, v 0.1 2019-09-09 5:40 PM lining Exp $
 */
public interface HelloDAO {

//    @Select("select * from helloworld where id = #{id}")
    HelloWorld selectHello(long id);

    void insertHello(@Param("name") String name);

    List<HelloWorld> queryAllHello();
}