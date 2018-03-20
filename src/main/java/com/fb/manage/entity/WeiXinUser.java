package com.fb.manage.entity;


import lombok.Data;
import lombok.extern.java.Log;

/**
 * @author slc
 */

@Data
public class WeiXinUser extends DataEntity{
    private String mobile;
    private String cusNumber;
    private String weixinId;
}
