package com.tuling.spring.mapper;

import com.tuling.spring.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    User selectByid(Integer id);

    User selectByid2(Integer id);

    int updateByid2(User user);

    int insertUser(User user);

//    List<User> selectIds(@Param("ids") List<Integer> ids);

}
