package com.fb.manage.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 基础控制
 * @author
 */
@Controller
@RequestMapping("/user")
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "hello" )
    @ResponseBody
    public String hello(){
        return "hello";
    }


    @RequestMapping(value = "index" , method = RequestMethod.POST )
    public String hello1(){
        return "index";
    }









}
