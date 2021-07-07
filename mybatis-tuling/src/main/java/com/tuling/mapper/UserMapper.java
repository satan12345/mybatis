package com.tuling.mapper;

import com.tuling.entity.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
//@CacheNamespace
public interface UserMapper {
    User selectById(Long id);

    @Select(" select id,user_name,create_time from t_user where id=#{id}")
    User selectById1(Long id);



}
