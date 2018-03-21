package com.fb.manage.common.cache;


import java.util.HashMap;
import java.util.Map;

/**
* @Author: lcc
* @Description:  线程缓存管理器
* @Date: 15:04 2018/3/21
* @params  * @param null
*/
public class ThreadCacheManager {

    private static Map<String ,ThreadCache> map ;

    static{
        map = new HashMap<>();
    }

    public static ThreadCache createCache(){
        ThreadCache threadCache = new ThreadCache();
        map.put(Thread.currentThread().getName(),threadCache);
        return threadCache;
    }

    public static ThreadCache getCache(){
        System.out.println(Thread.currentThread().getName());
        return map.get(Thread.currentThread().getName());
    }

}
