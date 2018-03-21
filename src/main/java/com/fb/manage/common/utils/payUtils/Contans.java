package com.fb.manage.common.utils.payUtils;

public class Contans {
	
	public static final String notify_url = "http://47.93.191.121:9000/notify_url";
	
	/**
	 * 支付宝参数
	 */
	/** 支付宝支付业务：入参app_id */
	public static final String APPID = "2017041306695171";
	
	/** 支付宝账户登录授权业务：入参pid值 */
	public static final String PID = "2088621832366452";
	/** 支付宝账户登录授权业务：入参target_id值 */

	/** 商户私钥，pkcs8格式 */
	
	public static final String RSA_PRIVATE = "MIIEugIBADANBgkqhkiG9w0BAQEFAASCBKQwggSgAgEAAoIBAQDhKXdathWjXHdne+6wIMX7ziZ+srEe6x7DGRlJEuv1m7Znfgr4S7lLo95tgCLM5JBCjyJGV6DT1YH4YjF4BfSFdLAKN+QKWdZfam0HEZPYQFUZ41W2QkmlUXtDHXI0THQ/ZDPIy3tdSQTZ7R/iqfhBwa9NJ0YWma3QMycE65/plFJkwA7F2htbLJQrW+PWUDUOtihhxmuqT1xxNxLA/poClJPFK+p4noAisw208kYXvOzEFXQBOKe9ArpLQof3d1amB44mkI8xI3WsW4uDpSAuPpC6TAUK44CctP1mJfV8QC/jZoG5wSpRqRQnxnOo8D/81sT7CksSzC6LvCsrcjDPAgMBAAECggEAaMimXdWtHjgy7TrUqqyl1nhqm73HBc9/omW0ybf/jW5opaMXsdNzqQrawXTHPTkFFaSM29V95/dNo+z2fpeu4siaADdgbZy/UeoyUP7SIepWcFTGl6ojocbYqTQz6LjHxJR6MPDZOWF4234pv49AFEHxteMYD/520BRuDTEmW0mmt/7IJNDlv0OZY8DXTbZceE9NDhuMOs+vtgIovbWfLsHMYPQGH2TUJW77ji33VrcObZbNStIL9N2ZETo9+qOe+D0mwhUeljFvCWFsl3Dm4UOWoFk6b/B1hEk7H1pN33ugEAnd4O93Xo0ntohZ0yeGZuPrh3+hT+LoTPuHz+xgUQKBgQD3wCII2cxm8Kxd34WUDzl8IFXQavw9A457C5lvp6//kwtrGxVQIH6dRIin88ojxj/pN9Uv4b9h+ZLz8RLcLPx+fKI29/pcz4radn5jDrcgZxl0Qib9NbKH/72SQbmEkgEGjxfmRj1B8Vxo8imEswvNFpJCwCOFAMQY+A5XUpqWqQKBgQDoqMjlptA7mpgLdcugPl3GD8stAGVA2rYU7bRG7bT/xzvGqVRYsYbFmMPpB+lT8dSIsSXcR27xFHcE51uI7s2GmeMwBfh02TTYU52idehY841cstWx6cx6TFjQ2BRDX1wurc9TWdG3BV2uPf9waZ886n7O1gZAck5BEvRR12FOtwJ/RLYEum+tQN9+7ooPggC28LYHFsaVLlbOLVIKO+1F4pvljs70GkTo2LUpMWtrpIBXOVdCyQTTD1koaH9zu5y+alYmpxgfV5435F74roBmSZZOeO/f4FoEKbPD38xap2nW3vrQpgzU8HUALBr9aNA/daHM7rZbI4gS2tnxIEbImQKBgB8+c2Qrx7EJbLu1QPgvB+bOPim38OEJvgQHe/s+dt0Wg1eFa9dRV9j3T+/eaR4lzrXgnEX9rc9gQS9+ZlN4Rk96IQFU++2tMaSPbg7gKKixZF17gqkWzafq0s6RBf+aMcXu/3WhDUG3zcHVf5U4CfNjRk4+fa5v60Rf6EGJW/73AoGAIfsAKQ7Orq9VuwTETzoaOUS6UAMbugR5oF/6cKDeti/UOB+F/BOUgD/IfTGRwTCDirunXh1AW12FXrNVCnjtsqko4CTQCGILsskuhgwDEbmb+NhdMmKSOrp8G8aC8vlqPZu4OFldLLHIM+RGhIn2kgtZBURZwQJtHjPFP7Tyklg=";
	public static final String pp = 		"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxATdmNlCD92DFD6sgIB9GiEgJIFI052ZyIy+WQao3tyjEz++kRmjbkKiV8CsrHmshwzSZKF50V6e6XX0z3rNxoN4Gly8/3JD5HLCN2YGOo3WOeJc4u08f08sHLmR1ex1GyHk8v/ydal2T32hKjb3WsfIO1NxF/YKAFEXKMluvJ4lC2wYqTmJsawC6qXGoT/BnkiH8hOPbnLuKavH8sDt8NUIN/I193NxIl6DfIHjfu7eYnbkMcVeWFSECiB6Uk6Dn4m62jM7kqO9Yr68citKX61/s63RC2rQD12hSfK+vZ6xMl5SXzNbsvkv9xDPuH85soZTqZvuzmr0o1bFnKHK7wIDAQAB";
	public static final String RSA_PUBLIC = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4Sl3WrYVo1x3Z3vusCDF+84mfrKxHusewxkZSRLr9Zu2Z34K+Eu5S6PebYAizOSQQo8iRleg09WB+GIxeAX0hXSwCjfkClnWX2ptBxGT2EBVGeNVtkJJpVF7Qx1yNEx0P2QzyMt7XUkE2e0f4qn4QcGvTSdGFpmt0DMnBOuf6ZRSZMAOxdobWyyUK1vj1lA1DrYoYcZrqk9ccTcSwP6aApSTxSvqeJ6AIrMNtPJGF7zsxBV0ATinvQK6S0KH93dWpgeOJpCPMSN1rFuLg6UgLj6QukwFCuOAnLT9ZiX1fEAv42aBucEqUakUJ8ZzqPA//NbE+wpLEswui7wrK3IwzwIDAQAB";

	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path ="C://";
	
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 接收通知的接口名
	public static String service = "mobile.securitypay.pay";
}
