package com.fb.manage.common.utils.myBatisUtils.table;

import lombok.Data;

/**
 * 数据库表字段记录表
 * @createDate : 2017/12/20 13:20
 * @ceeateName : MEINANZI
 */
@Data
public class MBTableField {
    private Integer tableId;  //主键
    private String fieldName; //字段名称
    private Boolean notNull; //非空
    private String pageName;   //字段显示在页面上的名称
    private String fieldType;  //字段属性
    private String defaultData;  // 字段默认值
    private String comment; //字段备注
    private Integer length;  //字段长度
}
