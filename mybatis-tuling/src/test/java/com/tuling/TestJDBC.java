package com.tuling;

import com.tuling.entity.User;
import org.junit.Test;

import java.sql.*;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class TestJDBC {

    @Test
    public void test() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2.创建连接
            conn = DriverManager.
                    getConnection("jdbc:mysql://192.168.9.223:3306/mybatis_example",
                            "root",
                            "ablejava");


            // SQL语句
            String sql = "select id,user_name,create_time from t_user where id=? ";

            // 获得sql执行者
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1);

            // 执行查询
            //ResultSet rs= pstmt.executeQuery();
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUserName(rs.getString("user_name"));
                user.setCreateTime(rs.getDate("create_time"));
                System.out.println(user.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testII() {
        BaseDao baseDao = new BaseDao();
        // 3个查询条件  1   2   3
        User user = baseDao.executeJavaBean("select id,user_name,create_time from t_user where id=?", User.class, 1);

        System.out.println(user);
    }

}
