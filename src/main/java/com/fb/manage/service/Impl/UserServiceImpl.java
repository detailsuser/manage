package com.fb.manage.service.Impl;

import com.fb.manage.entity.User;
import com.fb.manage.mapper.UserMapper;
import com.fb.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User select() {

        return userMapper.selectByPrimaryKey(1);
    }

    /**
     *  用户登录
     * @param rescod
     * @return  1：成功  2：失败  map《String,Object》
     */
    @Override
    public int selectJob(User rescod) {
        List<User> user = userMapper.selectByJobUser(rescod);


        return 0;
    }
}
