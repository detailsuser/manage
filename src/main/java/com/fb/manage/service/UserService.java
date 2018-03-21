package com.fb.manage.service;

import com.fb.manage.entity.User;

/**
* @Author: lcc
* @Description:  用户操作接口
* @Date: 17:08 2018/3/21
* @params  * @param null
*/
public interface UserService {

   public User select();

   public int selectJob(User rescod);

}
