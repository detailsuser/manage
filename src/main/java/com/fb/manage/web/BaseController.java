package com.fb.manage.web;

import com.fb.manage.entity.User;
import com.fb.manage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = "index" )
    public String hello1(){


      User user =  userService.select();
        System.out.println(user.toString());
        return "index";
    }




}
