package com.fb.manage.common.utils.myBatisUtils.table;


import lombok.Data;

/**
 * 数据库表记录表
 * @createDate : 2017/12/20 13:20
 * @ceeateName : MEINANZI
 */
@Data
public class MBTable {
    private Integer tableId;    //主键
    private String tableName;   //表名
    private Integer statusCode; //0表示未创建  1表示已创建  2表示已创建但更新未提交  3表示已创建但删除未提交
    private String ownerTable;  //继承的表
    private Integer tableType; //表类型   是否为实体表类   实体表为在数据库中有对应的表   非实体表为数据库中没有对应的表
    private String packageName; //对应额实体类全限定包名
    private String fileMD5; //文件校验码   确保数据库生成的文件与本地的文件是一致的
//    private Boolean
}
