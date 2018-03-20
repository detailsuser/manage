package com.fb.manage.service.Impl;

import com.fb.manage.entity.User;
import com.fb.manage.mapper.UserMapper;
import com.fb.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User select() {

        return userMapper.selectByPrimaryKey(1);
    }
}
