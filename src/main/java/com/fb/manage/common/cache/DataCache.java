package com.fb.manage.common.cache;

import com.fb.manage.common.utils.RWLock;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据缓存
 * @createDate : 2017/11/21 16:11
 * @ceeateName : MEINANZI
 */

public class DataCache<E> extends RWLock {
    public static final long defaultTime = 1000 * 60 * 60 * 4;  //默认有效时间  4小时

    @Getter
    private List<E> value;//缓存数据
    @Setter
    private boolean expired; //是否有效   无效的消除掉   超时的无效   即将删除的无效
    @Getter
    private long timeOut;//失效时间

    //-----------------------------------------------------------------------------------------------------------------------------

    //初始化代码块
    {
        timeOut = System.currentTimeMillis() + defaultTime;
        value = new ArrayList<>();
        expired = true;
    }

    //-----------------------------------------------------------------------------------------------------------------------------

    /**
     * 构造方法
     * @param value  需要存储的值
     */
    public DataCache(List<E> value) {
        this.value = value;
    }

    //-----------------------------------------------------------------------------------------------------------------------------

    /**
     * 判断当前缓存是否有效
     * @return  true  当前缓存有效<br/>
     *          false  当前缓存无效
     */
    public boolean isExpired() {
        if (expired && timeOut > System.currentTimeMillis()){
            return true;
        }
        return false;
    }
}
