package com.fb.manage.web;

import com.fb.manage.entity.User;
import com.fb.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基础控制
 * @author
 */
@RestController
@RequestMapping("/user")
public class BaseController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "hello" )
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "index" , method = RequestMethod.GET)
    public int hello1(User user){
      //检查有没有该用户
      //检查密码
      //
      User user2 =  userService.select();
        System.out.println(user2.toString());
        if (user.getJob() != null){
            return 1;
        }
        return 2;
    }




}
