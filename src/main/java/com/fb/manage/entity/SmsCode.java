/**
 * 
 */
package com.fb.manage.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author slc
 * 短信
 */
public class SmsCode  extends DataEntity{
	
	private static final long serialVersionUID = 1L;
	private String mobile;		// 用户手机号
	private String code;		// 验证码
	private String status;		// 是否成功： 0.失败，1.成功
	private String source;		// 来源
	private String channel;		// 渠道源
	private Date createTime;		// 发送时间
	private Integer type;		// 类型：1.注册；2.找回密码
	private String message;//短信内容	
	
	public SmsCode() {
		super();
	}


	@Length(min=0, max=11, message="用户手机号长度必须介于 0 和 11 之间")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Length(min=0, max=8, message="验证码长度必须介于 0 和 8 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=2, message="来源长度必须介于 0 和 2 之间")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Length(min=0, max=2, message="渠道源长度必须介于 0 和 2 之间")
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}