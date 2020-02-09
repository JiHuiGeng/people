package com.geng.test;

import com.geng.pojo.People;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//        session.selectList("com.geng.mapper.PeopleMapper.selectPeople");
//        //测试传参查询单行people数据:selectOne(指定标签id名：namespace+id,id);
//        People p = session.selectOne("com.geng.mapper.PeopleMapper.selectOne", 1);
//        System.out.println("测试传参查询单行people数据:" + p);
//        Map<String, Object> map = new HashMap<>();
//        //显示数据数
//        int pageSize = 2;
//        //要求从哪里开始
//        int pageNumber = 1;
//        //显示页数
//        map.put("pageSize", pageSize);
//        //经计算后的当前页数
//        map.put("pageStart", pageSize * (pageNumber - 1));
//        List<People> list = session.selectList("com.geng.mapper.PeopleMapper.page", map);
//        System.out.println(list);
        //新增people信息
        People people = new People();
        people.setName("新增name");
        people.setAge(33);
        int insertResault = session.insert("com.geng.mapper.PeopleMapper.insertPeopleInformation", people);
        //mybatis底层使用的是JDBC，而JDBC默认是不自动提交事务的，
        // 所以，在执行增删改时，我们要么在执行完SQL语句之后手动提交事务（调用commit()），
        // 要么使factory.openSession(true)方法，设置为自动提交事务
        session.commit();
        if (insertResault > 0) {
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败");
        }
        session.close();
    }
}
