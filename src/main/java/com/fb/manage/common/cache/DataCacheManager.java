package com.fb.manage.common.cache;


import com.fb.manage.common.utils.myBatisUtils.query.QueryArgs;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * 数据缓存管理器
 * @createDate : 2017/11/22 9:48
 * @ceeateName : MEINANZI
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE) //提供一个隐私的无参构造方法  实现单实例构造
public class DataCacheManager {
    //缓存    key 由三部分构成    类名 + 方法名  + 查询参数
    private static Map<Key , DataCache> cacheMap ;
    //key的存储点   根据类来区分
    private static Map<Class,Set<Key>> keyMap;

    //-----------------------------------------------------------------------------------------------------------------------------

    //初始化赋值代码块
    static{
        keyMap = new HashMap<>();
        cacheMap = new HashMap<>();
    }

    //-----------------------------------------------------------------------------------------------------------------------------

    /**
     * 获取缓存
     * @param key
     * @return
     * @throws Exception
     */
    public static List getCache(Key key){
        DataCache dataCache  = cacheMap.get(key);
        if (dataCache == null || !dataCache.isExpired()){  //缓存不存在  或  缓存已无效
            return null;
        }
        return dataCache.getValue();
    }

    //-----------------------------------------------------------------------------------------------------------------------------

    /**
     * 写入缓存  putCache方法  clearCache方法  需要同步<br/>
     * 只有在缓存对象是空的或者过期了之后  才能在创建一个新的
     * @param key
     */
    public static void putCache(Key key, List cacheValue) {
        //锁表操作
        synchronized (key.getCls()){
            //获取缓存
            DataCache dataCache = cacheMap.get(key);
            //判断缓存是否存在或过期
            if (dataCache == null || !dataCache.isExpired()){  //缓存不存在或无效   可以创建一个新的缓存对象
                //在map中创建一个缓存对象
                cacheMap.put(key,new DataCache(cacheValue));
                //将节点放入到key节点表中
                Set keySet = keyMap.get(key.getCls());
                if (keySet == null){
                    keyMap.put(key.getCls(),(keySet = new HashSet()));
                }
                keySet.add(key);
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------

    /**
     * 清理缓存    <br/>
     * 一张表里面的一条数据更新 删除 插入  缓存中该表的所有数据都移除
     */
    public static void cleanCache(Class cls) {
        //锁表  同步操作
        synchronized (cls) {
            //取出该类下的所有key
            Set<Key> keySet = keyMap.get(cls);
            //将所对应的缓存对象做无效处理
            if (keySet != null) {
                for (Key key : keySet) {
                    DataCache dataCache = cacheMap.get(key);
                    if (dataCache != null){
                        dataCache.setExpired(false);
                    }
                }
            }
            //已将所有的key对应的缓存清理   这些key也不需要了   将keySet清除
            keyMap.remove(cls);
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------

    /**
     * key 由三部分构成    方法的类名 + 方法名  + 查询参数对象
     */
    @Data
    @AllArgsConstructor
    public static class Key {
        private Class cls;  //类
        private String methodName;  //方法名
        private QueryArgs parameter;  //查询参数
    }
}
