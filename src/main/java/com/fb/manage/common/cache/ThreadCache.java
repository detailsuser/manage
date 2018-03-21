package com.fb.manage.common.cache;

import lombok.Data;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 线程缓存   只有在用户登录的情况下才需要开启
 * @createDate : 2017/11/30 9:11
 * @ceeateName : MEINANZI
 */
@Data
public class ThreadCache {
    //较常用到的属性  写入到线程缓存中去
    private String userId;              //用户的userId   用来查询数据库资料
    private String loginCode;           //用户的登录码   记录同一次登录下的所有请求
    private String actionCode;          //当前用户的操作码   记录同一次请求下的所有操作  获取到一个用户请求时分发一个给用户

    private Map requestParameterMap;    //request传递回来的参数

    private HttpSession session;    //request中的session
}
