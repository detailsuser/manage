package com.fb.manage.entity;


import lombok.Data;

import java.util.Date;

@Data
public class DataEntity {

    private static final long serialVersionUID = 1L;
    // 备注
    protected String remarks;
    // 创建日期
    protected Date createDate;
    // 更新日期
    protected Date updateDate;
}
