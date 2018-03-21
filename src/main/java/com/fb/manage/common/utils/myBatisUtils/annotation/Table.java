package com.fb.manage.common.utils.myBatisUtils.annotation;

import java.lang.annotation.*;

/**
 * 数据库实体类注解
 * @createDate : 2017/11/15 17:07
 * @ceeateName : MEINANZI
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    /**
     * 表名称
     */
    String tableName();

//    /**
//     * 是否分表
//     */
//    boolean isSubTable() default false;

    /**
     * 分页数
     * @return
     */
    int pageIndex() default 20;
}
