package com.fb.manage.common.utils.myBatisUtils.table;

import lombok.Data;

/**
 * 表 和 表字段  一对多关系表
 * @createDate : 2017/12/20 13:21
 * @ceeateName : MEINANZI
 */
@Data
public class OneToMore_MBTableToMBTableField {
    private Integer tableId;        //主键id
    private Integer dbTableId;      //DBTable表的id
    private Integer dbTableFieldId; //DBTableField表的id
}
