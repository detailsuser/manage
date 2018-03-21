package com.fb.manage.web;

import com.fb.manage.entity.User;
import com.fb.manage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 基础控制
 * @author
 */
@Slf4j
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
    public int hello1(User rescod){

        return userService.selectJob(rescod);
    }




}
