package com.tuling.spring.service.impl;


import com.tuling.spring.mapper.UserMapper;
import com.tuling.spring.model.User;
import com.tuling.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tommy
 * Created by Tommy on 2019/7/4
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;//将userMapper代理对象-->作为一个bean放入到Sprnig容器中

    @Override
    public User getUser(Integer id) {
        userMapper.selectByid(id);
        return userMapper.selectByid(id);
    }

    @Override
    @Transactional
    public User getUser2(Integer id) {
        userMapper.selectByid(id);
        return userMapper.selectByid(id);
    }

    @Override
    @Transactional()
    public void registerUser(User user) {
        userMapper.insertUser(user);
        int i = 1 / 0;
    }
}
