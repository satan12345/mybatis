package com.tuling;

import com.tuling.entity.User;
import com.tuling.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Proxy;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 一级缓存使用条件：
 *      必须是同一个会话
 *      必须是相同的mapper
 *      必须是相同的方法
 *      查询语句中间没有执行增删改
 * 二级缓存的使用条件:
 *      当会话提交或关闭之后才会填充二级缓存
 *      必须是在同一个命名空间之下
 *      必须是相同的statement 即同一个mapper接口中的同一个方法
 *      必须是相同的sql语句和参数
 * 二级缓存清除条件：
 *  xml中配置的update不能清空@CacheNameSpace中的缓存数据
 *  只有修改会话提交之后 才会执行清空操作
 *  任何一种增删改操作 都会清空整个namespace中的缓存
 *
 *
 */
public class App {
    public static void main(String[] args) {

        Reader reader;
        try {
            //将XML配置文件构建为Configuration配置类
//            reader = Resources.getResourceAsReader(resource);
            String resource = "mybatis-config.xml";
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            // 通过加载配置文件流构建一个SqlSessionFactory  DefaultSqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            // 数据源 执行器  DefaultSqlSession
            SqlSession session = sqlSessionFactory.openSession();
//            SqlSession session1 = sqlSessionFactory.openSession();
            try {
                // 执行查询 底层执行jdbc
//                User user = session.selectOne("com.tuling.mapper.UserMapper.selectById", 1);
//                System.out.println("user = " + user);

                //获得代理对象
                UserMapper mapper = session.getMapper(UserMapper.class);
                User user1 = mapper.selectById(1L);
//                session.close();
//                UserMapper mapper1 = sqlSessionFactory.openSession().getMapper(UserMapper.class);
//                User user2 = mapper1.selectById(1L);
//                System.out.println(user1 == user2);
//                session.clearCache();
//                User user2 = mapper.selectById(1L);
//                System.out.println(user1 == user2);
//                //不同会话
//                final UserMapper mapper1 = session1.getMapper(UserMapper.class);
//                final User user3 = mapper1.selectById(1L);
//                System.out.println(user1 == user3);
//                System.out.println(user.getUserName());
//
//                UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(User.class.getClassLoader(),
//                        new Class[]{UserMapper.class}, (proxy, method, args1) -> {
//                            System.out.println("方法" + method.getName() + "被调用了,参数为" + args1);
//                            return null;
//                        });
//                userMapper.selectById(123L);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
