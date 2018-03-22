package com.fb.manage.service.Impl;

import com.fb.manage.entity.User;
import com.fb.manage.mapper.UserMapper;
import com.fb.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private  HttpServletRequest request;

    private HttpServletResponse response;

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
    public Integer selectJob(User rescod) {
        if (null != rescod.getJob()){
            User user = userMapper.selectByJobUser(rescod);
            if (null != user){
                if (rescod.getPassword().equals(user.getPassword())){
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     * web登入
     * @param rescod
     * @return
     */
    @Override
    public int selectTel(User rescod) {
        if (null != rescod.getTel()){
            User user = userMapper.selectByPassword(rescod);

            if (null != user){
                HttpSession session = request.getSession();
                //把用户数据保存在session域对象中
                session.setAttribute("loginUser", user);
                if (rescod.getPassword().equals(user.getPassword())){
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override
    public User selectUser(User rescod) {
        //取用户数据


        return null;
    }


}
