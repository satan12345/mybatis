package com.tuling.spring.service;


import com.tuling.spring.model.User;

/**
 * @author Tommy
 * Created by Tommy on 2019/7/4
 **/
public interface UserService {
    User getUser(Integer id);

    User getUser2(Integer id);

    void registerUser(User user);
}
