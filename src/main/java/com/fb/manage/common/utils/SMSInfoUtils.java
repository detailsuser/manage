package com.fb.manage.common.utils;

/**
 * 短信信息工具类
 * 
 * @author lh
 *
 */
public class SMSInfoUtils {
	
	public static final int TYPEPHONECODE = 1;
	public static final int TYPERECHARGESUCC = 2;
	public static final int TYPEWITHDRAWAPPLY = 3;
	public static final int TYPEBUYSUCC = 4;
	public static final int REGISTERPASSWORD = 5;
	public static final int LUCKYDRAW = 6;
	/**
	 * 手机验证码
	 */
	private static String phoneCode = "您正在进行短信验证，验证码为%s,五分钟内有效，为确保您的账户安全，请勿向任何人泄露您的验证码。";
	/**
	 * 充值成功
	 */
	private static String rechargeSucc = "尊敬的%s用户，您申请充值金额%s元已充值成功，请进入“个人中心”查看您的充值详情。";
	/**
	 * 提现申请
	 */
	private static String withdrawApply = "尊敬的%s用户，您于%s提交的%s元提现申请已受理，资金将于T+1个工作日内到达您的银行账户。";
	/**
	 * 购买成功(产品，金额)
	 */
	private static String buySucc = "尊敬的用户，您已成功出借%s，出借金额%s元。 ";
	/**
	 * 注册成功,发送验证码
	 */
	private static String registerPassword = "尊敬的用户欢迎您注册巨潮金融理财,你的初始密码八位密码为%s，建议您尽快登陆本网站修改您的初始密码。";
	private static String activty = "亲，您已成功获得%s元手机话费，话费将在满足活动条件后3个工作日内存入您的%s手机号码中，如有疑问可添加公众号巨潮金融或拨打客服热线4000-068-069。";
//	public static void main(String[] args) {
//		System.out.println(generateInbox(1, "AAA"));
//		System.out.println(generateInbox(2, "AAA"));
//		System.out.println(generateInbox(3, "2015-1-1", "1111"));
//		System.out.println(generateInbox(4, "AAA", "10"));
//	}

	/**
	 * 根据类型生成短信息
	 * 
	 * @param type
	 *            1.手机验证码;5.注册成功发送密码 ;6.活动
	 * @param params
	 * @return
	 */
	public static String generateInfo(int type, String params) {
		String result = null;
		switch (type) {
		case 1:
			result = String.format(phoneCode, params);
			break;
		case 5:
			result = String.format(registerPassword, params);
			break;
		}
		return result;
	}

	/**
	 * 根据类型生成短信息
	 * 
	 * @param type
	 *           2.充值成功; 3.提现申请；4.购买成功
	 * @param date
	 * @param money
	 * @return
	 */
	public static String generateInfo(int type, String param, String money) {
		String result = null;
		switch (type) {
		case 2:
			result = String.format(rechargeSucc, param,money);
			break;
		case 4:
			result = String.format(buySucc, param, money);
			break;
		case 6:
			result = String.format(activty, param,money);
			break;
		}
		return result;
	}
	public static String generateInfo(int type, String param, String time,String money) {
		String result = null;
		switch (type) {
		case 3:
			result = String.format(withdrawApply, param,time, money);
			break;
		}
		return result;
	}
	/**
	 * 根据类型生成站內信
	 * 
	 * @param type
	 *            1.手机验证码;2.充值成功
	 * @param code
	 * @return
	 */
	public static String generateInbox(int type, String params) {
		String result = null;
		switch (type) {
		case 1:
			result = String.format(phoneCode, params);
			break;
		case 2:
			result = String.format(rechargeSucc.replace("尊敬的%s用户，", ""), params);
			break;
		}
		return result;
	}
	
	/**
	 * 根据类型生成站內信
	 * 
	 * @param type
	 *            3.提现申请；4.购买成功
	 * @param date
	 * @param money
	 * @return
	 */
	public static String generateInbox(int type, String param, String money) {
		String result = null;
		switch (type) {
		case 3:
			result = String.format(withdrawApply.replace("尊敬的%s用户，", ""), param, money);
			break;
		case 4:
			result = String.format(buySucc.replace("尊敬的%s用户，", ""), param, money);
			break;
		}
		return result;
	}
}
