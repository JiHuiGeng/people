package com.geng.test;

import com.geng.pojo.People;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis+log4j
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //首先读取mybatis-config.xml文件的全局配置属性，解析成字节流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //创建工厂,使用工厂建造者，将获取的字节流再次解析成对应的工厂
        // new SqlSessionFactoryBuilder().build()是构建者设计模式，用于实例化工厂对象，特点是有build()
        // SqlSessionFactory factory是工厂设计模式
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //工厂生产对应的session会话
        SqlSession session = factory.openSession();
        session.selectList("com.geng.mapper.PeopleMapper.selectPeople");
        //测试传参查询单行people数据:selectOne(指定标签id名：namespace+id,id);
        People p = session.selectOne("com.geng.mapper.PeopleMapper.selectOne", 1);
        System.out.println("测试传参查询单行people数据:"+p);
        session.close();
    }
}
