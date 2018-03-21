package com.fb.manage.common.utils.myBatisUtils.base;

import lombok.Data;

import java.util.Date;

/**
 *
 * @createDate : 2017/12/25 11:08
 * @ceeateName : MEINANZI
 */
@Data
public class BaseDO {
    private Integer tableId;//   	表id   一般为自增主键
    private Integer version;//      乐观锁字段
    private Date createDate;//  	创建时间
}
