package com.fb.manage.web;

import com.fb.manage.entity.User;
import com.fb.manage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 基础控制
 * @author
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "hello" )
//    @ResponseBody
    public String hello(){
        return "index";
    }

    /**
     * android登入
     * @param rescod
     * @return
     */
    @RequestMapping(value = "login" , method = RequestMethod.GET)
    @ResponseBody
    public int login(User rescod){

        int i = userService.selectJob(rescod);
        if (i ==1){
            return 1;
        }
        return 0;
    }

    /**
     * web登入
     * @param rescod
     * @return
     */
    @RequestMapping(value = "loginweb" , method = RequestMethod.GET)
    @ResponseBody
    public int loginweb(User rescod,HttpServletRequest request, HttpServletResponse response){

        int i = userService.selectTel(rescod);
        if (i ==1){
            return 1;
        }
        return 0;
    }

 /**
     * 查询个人信息
     * @param rescod
     * @return
     */
    @RequestMapping(value = "selectUser" , method = RequestMethod.GET)
    @ResponseBody
    public User selectUser(User rescod){

       return userService.selectUser(rescod);
    }




}
