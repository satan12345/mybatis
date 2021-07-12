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

        try {
            String resource = "mybatis-config.xml";
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            // 数据源 执行器  DefaultSqlSession
            SqlSession session = sqlSessionFactory.openSession();

            try {

//                User user = session.selectOne("com.tuling.mapper.UserMapper.selectById", 1);
//                System.out.println("user = " + user);

                //获得代理对象
                UserMapper mapper = session.getMapper(UserMapper.class);
                User user1 = mapper.selectById1(1L);

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
