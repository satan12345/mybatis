package com.tuling;


import com.tuling.spring.mapper.UserMapper;
import com.tuling.spring.model.User;
import com.tuling.spring.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author Tommy
 * Created by Tommy on 2019/6/28
 **/
public class SpringDemo {

    //factoryBean
    @Test
    public void test1() {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("spring.xml");
        //  单例 还是多例?
        //  应用生命周期是一样的
        //  跨线程 用的
        UserMapper userMapper = context.getBean(UserMapper.class);
        User user = userMapper.selectByid2(1);
        System.out.println("user = " + user);
//        SqlSession sqlSession = null;
//        UserMapper userMapper2 = sqlSession.getMapper(UserMapper.class);
    }


    @Test
    public void test2() {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getUser2(1));
    }


//    @Test
//    public void test3() {
//        ClassPathXmlApplicationContext context
//                = new ClassPathXmlApplicationContext("spring.xml");
//        //  单例 还是多例?
//        //  应用生命周期是一样的
//        //  跨线程 用的
//        UserMapper userMapper = context.getBean(UserMapper.class);
//        System.out.println(userMapper.selectIds(Arrays.asList(1, 2, 3)));
//
//    }

}
