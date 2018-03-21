package com.fb.manage.common.utils.myBatisUtils.query;


import com.fb.manage.common.utils.DateUtil;
import com.fb.manage.common.utils.myBatisUtils.annotation.Table;
import lombok.Data;

import java.text.ParseException;
import java.util.Date;

/**
 * 查询参数  有分页查询  等参数
 * @createDate : 2017/11/7 14:48
 * @ceeateName : MEINANZI
 */
@Data
public class QueryArgs<E> {
    //表前缀
    private static final String fixName = "tb_";

    //数据
    private E valueData;
    private String whereSql;

    private Date newDate;   //当前时间
    private Date startDate; //时间区间属性  开始时间
    private Date endDate;   //时间区间属性  结束时间
    //表名称
    private String tableName;
    //从第几条开始查询
    private Integer index = 0;
    //一页的条数  分页的数量
    public static final Integer pageNumber = 20;

    public QueryArgs(E e) throws ParseException {
        this.valueData = e;
        //获取注解
        Table table = e.getClass().getAnnotation(Table.class);
        //获取查询的表名称
        tableName = fixName + table.tableName();
        //当前时间赋值
        newDate = DateUtil.getSexSimp().parse(DateUtil.getSexSimp().format(new Date()));
    }

    /**
     * 设置分页查询开始的页数
     * @param pageIndex  第几页开始查询
     */
    public void setPageIndex(int pageIndex){
        if (pageIndex > 0){
            index = pageIndex * pageNumber;
        }
    }
}
