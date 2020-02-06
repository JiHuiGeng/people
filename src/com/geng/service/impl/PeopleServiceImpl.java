package com.geng.service.impl;

import com.geng.pojo.People;
import com.geng.service.PeopleService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 一般service层不处理异常，只抛出异常
 * dao或controller层才做异常处理
 */
public class PeopleServiceImpl implements PeopleService {
    /**
     * 查询人员信息——业务逻辑处理
     *
     * @return
     */
    @Override
    public List<People> showAll() throws IOException {
        //首先读取mybatis-config.xml文件的全局配置属性，解析成字节流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //创建工厂,使用工厂建造者，将获取的字节流再次解析成对应的工厂
        // new SqlSessionFactoryBuilder().build()是构建者设计模式，用于实例化工厂对象，特点是有build()
        // SqlSessionFactory factory是工厂设计模式
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //工厂生产对应的session会话
        SqlSession session = factory.openSession();
        //会话再调用对应的selectList方法,返回list结果
        List<People> list = session.selectList("com.geng.mapper.PeopleMapper.selectPeople");
        session.close();
        return list;
    }
}
