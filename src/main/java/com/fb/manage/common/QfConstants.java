
package com.fb.manage.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量类
 * @author lh
 */
public class QfConstants {


	/**
	 * 短信验证码有效时间 5分钟
	 */
	public static int smsValidTime = 5;

	public final static String RESULTBEAN_SUCCESS = "success";

	public final static String ERROR_INFO = "服务器维护中";
	/**
	 * 连续输入错误登录限制时间300秒
	 */
	public static int loginLimitTime = 300;
	/**
	 * 再次获取验证码时间 1分钟
	 */
	public static int getValidTime = 1;

	public static Map<String, Map<String, String>> constanMap = new HashMap<String, Map<String, String>>();

	public static Map<String, String> borrowTypeDescMap = new HashMap<String, String>();
	// 省份直辖市列表
	public static List<String> pList = new ArrayList<String>();
	
	public static Map<String,String> productMap = new HashMap<String, String>();

	static {
		Map<String, String> map = new HashMap<>();
		map.put("0", "充值");
		map.put("1", "提现");
		map.put("2", "产品投资");
		map.put("3", "散标投资");

		borrowTypeDescMap.put("1",
				"借款额度5-500万元\n\n面向23到55周岁，企业法定代表人或持股20%以上的股东。\n\n申请材料：身份证、征信报告、住址证明、银行流水、经营证明、经营收入证明、结婚证/离婚证。");
		borrowTypeDescMap.put("2",
				"借款额度2-30万元\n\n面向23到55周岁，月薪3500元以上公务员和白领阶层。\n\n申请材料：身份证、社保/公积金缴纳明细、征信报告、工作证明、收入证明、住址证明、结婚证/离婚证。");
		borrowTypeDescMap.put("3", "借款额度2-15万元\n\n面向23到55周岁，个人名下有房产月收入3500元以上人群。\n\n申请材料：身份证、房产证明、征信报告、工作证明、收入证明、住址证明。");
		borrowTypeDescMap.put("4",
				"借款额度4-30万元\n\n面向23到55周岁，持有总期限满3年月供超过200元的寿险保单人群。\n\n申请材料：身份证、保单、征信报告、工作证明、收入证明、住址证明、结婚证/离婚证。");

		// map = new HashMap<>();
		// map.put("1", "网站");
		// map.put("2", "IOS");
		// map.put("3", "Android");
		// map.put("4", "微信");
		// map.put("5", "Wap");
		// constanMap.put("user_channel", map);
		// map = new HashMap<>();
		// map.put("0", "到期本息");
		// map.put("1", "等额本息");
		// map.put("2", "按月付息");
		// constanMap.put("borrow_style", map);
		// map = new HashMap<>();
		// map.put("1", "到期本息");
		// map.put("2", "按月付息");
		// constanMap.put("refund_type", map);
		// map = new HashMap<>();
		// map.put("1", "投资中");
		// map.put("2", "满标");
		// map.put("3", "还款中");
		// map.put("4", "结标");
		// map.put("5", "逾期");
		// constanMap.put("borrow_status", map);
		// map = new HashMap<>();
		// map.put("1","企业借款");
		// map.put("3","易居借款");
		// map.put("4","保单借款");
		// map.put("2","精英借款A");
		// map.put("5","精英借款B");
		// map.put("6","精英借款C");
		// constanMap.put("bao_product_id", map);
		// map = new HashMap<>();
		// map.put("1","用户申请");
		// map.put("2","后台审核通过");
		// map.put("3","线下审核通过");
		// constanMap.put("bao_status", map);
		// map = new HashMap<>();
		// map.put("15","未收息");
		// map.put("20","收息中");
		// map.put("40","已收息");
		// constanMap.put("product_status", map);
		
		constanMap.put("recover_status", map);
    	map = new HashMap<>();
    	map.put("0", "无");
    	map.put("1", "有");
    	constanMap.put("house", map);//房产
    	map = new HashMap<>();
    	map.put("0", "无");
    	map.put("1", "有");
    	constanMap.put("chechan", map);//车产
    	map = new HashMap<>();
    	map.put("0", "未婚");
    	map.put("1", "已婚");
    	constanMap.put("marrige", map);//婚姻
    	map = new HashMap<>();
    	map.put("1", "小学");
    	map.put("2", "初中");
    	map.put("3", "高中");
    	map.put("4", "大专");
    	map.put("5", "本科");
    	map.put("6", "硕士");
    	map.put("7", "博士");
    	constanMap.put("xueli", map);//学历

		
		pList.add("北京");
		pList.add("天津");
		pList.add("上海");
		pList.add("重庆");
		pList.add("河北");
		pList.add("河南");
		pList.add("云南");
		pList.add("辽宁");
		pList.add("黑龙江");
		pList.add("湖南");
		pList.add("安徽");
		pList.add("山东");
		pList.add("新疆");
		pList.add("江苏");
		pList.add("浙江");
		pList.add("江西");
		pList.add("湖北");
		pList.add("广西");
		pList.add("甘肃");
		pList.add("山西");
		pList.add("内蒙古");
		pList.add("陕西");
		pList.add("吉林");
		pList.add("福建");
		pList.add("贵州");
		pList.add("广东");
		pList.add("青海");
		pList.add("西藏");
		pList.add("四川");
		pList.add("宁夏");
		pList.add("海南");
		pList.add("台湾");
		pList.add("香港");
		pList.add("澳门");
		
		
		productMap.put("juhcaoBAOOL", "XX宝");
		productMap.put("juhcaoBAOOLNEW", "XX宝");
		productMap.put("YUEXIBAOOL", "月息宝");
		productMap.put("SHUANGJIYINGOL", "双季盈");
		productMap.put("JIJIYINGOL", "季季盈");
		productMap.put("YUEXIYINGOL", "月息盈");
		productMap.put("XINSHOU", "新手专享");
		productMap.put("juhcaoBAO18", "XX宝-18");
		productMap.put("JIUJIUYING", "久久赢");
		productMap.put("FUAIRUSHAN", "父爱如山");
		productMap.put("FUAIJIUJIU", "父爱久久");
		//productMap.put("XUEZIYOU", "学子游");
	}

	public static String getLabel(String key, String type) {
		Map<String, String> map = constanMap.get(type);
		return map.get(key);
	}

	// 用户来源
	public static int USER_SOURCE_OFFLINE = 1; // 线下
	public static int USER_SOURCE_ONLINE = 2; // 线上
	
	// 用户渠道
	public static int USER_CHANNEL_WEB = 1; // 网站
	public static int USER_CHANNEL_IOS = 2; // IOS
	public static int USER_CHANNEL_ANDROID = 3; // Android
	public static int USER_CHANNEL_WECHAT = 4; // 微信
	public static int USER_CHANNEL_WAP = 5; // Wap

	// 登录状态
	public static int IS_LOGIN_SUCCESS = 1; // 成功
	public static int IS_LOGIN_FAILURE = 0; // 失败

	// banner类型
	public static int BANNER_TYPE_INDEX = 1; // 首页
	public static int BANNER_TYPE_ACTIVITY = 2; // 活动专区

	// 银行账户类型
	public static String ACCOUNT_TYPE_CARD = "1"; // 储蓄卡
	public static String ACCOUNT_TYPE_BOOK = "2"; // 存折

	// 账户日志类型
	public static String ACCOUNT_LOG_TYPE_RECHARGE = "0"; // 充值
	public static String ACCOUNT_LOG_TYPE_WITHDRAWAL = "1"; // 提现
	public static String ACCOUNT_LOG_TYPE_BUYPRODUCT = "2"; // 购买理财
	public static String ACCOUNT_LOG_TYPE_BUYBORROW = "3"; // 购买散标
	public static String ACCOUNT_LOG_TYPE_INVESTAUTORANSOM = "4"; // 理财自动赎回
	public static String ACCOUNT_LOG_TYPE_BORROWAUTORANSOM = "5"; // 散标自动赎回
	public static String ACCOUNT_LOG_TYPE_BORROW_MANUAL_RETURN = "6"; // 散标手动回款
	public static String ACCOUNT_LOG_TYPE_DEFAULT_INTEREST = "7"; // 罚息
	public static String ACCOUNT_LOG_TYPE_WITHDRAWAL_SUCC = "8"; // 提现成功
	public static String ACCOUNT_LOG_TYPE_WITHDRAWAL_FAIL = "9"; // 提现失败
	public static String ACCOUNT_LOG_TYPE_PAY_INTEREST = "10";// 派息
	public static String ACCOUNT_LOG_TYPE_PAY_RECOMMEND_BONUS = "11"; //推荐奖励
	public static String ACCOUNT_LOG_TYPE_PAY_ACTIVITY_BONUS = "12"; //活动奖励
	public static String ACCOUNT_LOG_TYPE_PAY_LB_RETURN = "13"; //13流标回款
	public static String ACCOUNT_LOG_TYPE_BUYTRANSFER = "14"; //购买转让
	public static String ACCOUNT_LOG_TYPE_SELLTRANSFER = "15"; //出让转让
	public static String ACCOUNT_LOG_TYPE_WITHDRAWAL_FEE = "16"; //16提现手续费
	
	// app调用参数
	public static String ACCOUNT_LOG_TYPE_23BUY = "23"; // 购买
	public static String ACCOUNT_LOG_TYPE_45RANSOM = "45"; // 赎回
	public static String ACCOUNT_LOG_TYPE_OHTER = "66"; // 其它

	// 充值到账状态
	public static String RECHARGE_ARRIVE_STATUS_NO = "1"; // 未到账
	public static String RECHARGE_ARRIVE_STATUS_YES = "2"; // 已到账

	// 充值状态
	public static String RECHARGE_STATUS_WAIT = "1"; // 等待充值
	public static String RECHARGE_STATUS_FINISH = "2"; // 充值完成

	// 用户银行卡状态
	public static String MEMBER_BANK_STATUS_NORMAL = "0"; // 正常
	public static String MEMBER_BANK_STATUS_DEL = "1"; // 删除
	
	// 用户银行卡绑定状态
	public static Integer MEMBER_BANK_ISBIND_NO = 0; // 未绑定
	public static Integer MEMBER_BANK_ISBIND_YES = 1; // 已绑定

	// 用户银行卡资料是否齐全
	public static Integer MEMBER_BANK_PASS_YES = 0; // 资料齐全
	public static Integer MEMBER_BANK_PASS_NO = 1; // 待补充

	// 短信验证码类型
	public static Integer SMS_CODE_TYPE_REG = 1; // 1.注册;

	public static Integer SMS_CODE_TYPE_FIND_PWD = 2; // 2.找回密码;

	public static Integer SMS_CODE_TYPE_MODIFY_PWD = 3; // 3.修改密码；

	public static Integer SMS_CODE_TYPE_FIND_PAY_PWD = 4; // 4.找回支付密码；

	public static Integer SMS_CODE_TYPE_MODIFY_PAY_PWD = 5; // 5.修改支付密码；

	public static Integer SMS_CODE_TYPE_SETTING_PAY_PWD = 6; // 6.设置支付密码
	
	public static Integer SMS_CODE_TYPE_MODIFY_MOBILE = 7; // 7.修改手机号
	
	public static Integer SMS_CODE_TYPE_BUY_INVEST = 8; // 8.购买理财

	public static Integer SMS_CODE_TYOE_MODIFY_MOBILE_NEW = 9;//9.修改手机号,新手机号验证码
	// 投资表续投类型
	public static String INVEST_APPLY_CONTINUE_TYPE_NON_CONTINUE = "1"; // 1：非续投，
	// 2：本金及收益全部续投，
	// 3：赎回收益，本金续投，
	// 4：赎回收益，部分本金续投，
	// 5：赎回收益，增加本金续投，
	// 6：本金及收益全部赎回后再次出借'

	// 投资表计息方式
	public static String INVEST_APPLY_CALCULATE_EARNINGS_DAY = "1"; // 1：按天计息，
	public static String INVEST_APPLY_CALCULATE_EARNINGS_MONTH = "2"; // 2：按月计息

	// 投资表全局状态
	public static String INVEST_APPLY_GLOBAL_STATUS_WAIT = "15";// 投资状态:15.等待计息
	public static String INVEST_APPLY_GLOBAL_STATUS_INTEREST = "20";// 投资状态:20.计息
	public static String INVEST_APPLY_GLOBAL_STATUS_REDEMPTION = "30";// 投资状态:30.赎回中
	public static String INVEST_APPLY_GLOBAL_STATUS_WAIT_EXIT = "50";// 投资状态:50.已打款(已退出)

	// 散标状态
	public static String BORROW_STATUS_OPEN = "0"; // 开标
	public static String BORROW_STATUS_TENDER = "1"; // 募集中
	public static String BORROW_STATUS_FULL = "2"; // 满标
	public static String BORROW_STATUS_REFUND = "3"; // 还款中
	public static String BORROW_STATUS_FINAL = "4"; // 结标
	public static String BORROW_STATUS_DELAY = "5"; // 逾期
	
	// 理财状态
	public static String PRODUCT_STATUS_OPEN = "0"; // 开标
	public static String PRODUCT_STATUS_TENDER = "1"; // 募集中
	public static String PRODUCT_STATUS_FULL = "2"; // 满标
	public static String PRODUCT_STATUS_REFUND = "3"; // 还款中
	public static String PRODUCT_STATUS_FINAL = "4"; // 结标
	public static String PRODUCT_STATUS_DELAY = "5"; // 逾期
	// 散标借款方式
	public static String BORROW_STYLE_DEBX = "1"; // 1：等额本息
	public static String BORROW_STYLE_DQHBFX = "2"; // 2：到期还本付息
	public static String BORROW_STYLE_AYFXDQHB = "3"; // 3：按月付息到

	// 提现状态
	public static String ACCOUNT_WITHDRAWAL_STATUS_WAIT = "1"; // 1：待处理
	public static String ACCOUNT_WITHDRAWAL_STATUS_EXEC = "2"; // 2：已处理
	public static String ACCOUNT_WITHDRAWAL_STATUS_SUCC = "3"; // 3：成功
	public static String ACCOUNT_WITHDRAWAL_STATUS_FAIL = "4"; // 4：失败

	// 区域类型
	public static Integer AREA_TYPE_PROVINCE = 1; // 省份
	public static Integer AREA_TYPE_CITY = 2; // 城市

	// 反馈意见状态
	public static Integer FEEDBACK_STATUS_NORMAL = 0;

	// 默认投标金额
	public static BigDecimal DEFAULT_TENDER_AMOUNT = new BigDecimal(100);

	// 理财产品回款方式
	public static String PRODUCT_REFUND_TYPE_DEBX = "1"; // 1：等额本息
	public static String PRODUCT_REFUND_TYPE_DQHBFX = "2"; // 2：到期还本付息
	public static String PRODUCT_REFUND_TYPE_AYFXDQHB = "3"; // 3：按月付息到

	public static String INBOX_ISREAD_YES = "1";
	public static String INBOX_ISREAD_NO = "0";
	
	
	// 用户表是否实名
	public static String CUSLOGIN_ISAUTO_YES = "1";
	public static String CUSLOGIN_ISAUTO_NO = "0";
	
	// 用户表是否购买免密支付
	public static Integer CUSLOGIN_BUYFREEPWD_YES = 1;
	public static Integer CUSLOGIN_BUYFREEPWD_NO = 0;
	
	// 用户红包类型
	public static String MEMBER_REDBAG_SCOPE_ALL = "juhcaoBAOOL,YUEXIBAOOL,SHUANGJIYINGOL,JIJIYINGOL,YUEMANYINGOL,YUEXIYINGOL,xinshou"; // 红包使用范围
	public static String MEMBER_REDBAG_SCOPE_1 = "juhcaoBAOOL,YUEXIBAOOL,SHUANGJIYINGOL,JIJIYINGOL,YUEMANYINGOL,YUEXIYINGOL"; // 红包使用范围
	public static String MEMBER_REDBAG_SCOPE_2 = "juhcaoBAOOL,YUEXIBAOOL,SHUANGJIYINGOL,JIJIYINGOL,YUEXIYINGOL"; // 红包使用范围
	
	public static String MEMBER_REDBAG_TYPE_REG = "0"; // 注册送红包
	public static String MEMBER_REDBAG_TYPE_VERIFY = "1"; // 认证送红包
	public static String MEMBER_REDBAG_TYPE_FIRST = "2"; // 首投送红包
	public static String MEMBER_REDBAG_TYPE_BOUNS = "3"; // 奖励送红包
	public static String MEMBER_REDBAG_TYPE_RECHARGE = "5"; // 活动红包
	// 用户红包使用类型
	public static String MEMBER_REDBAG_USETYPE_INVEST = "0"; // 理财投资
	// 用户红包状态
	public static String MEMBER_REDBAG_STATUS_NORMAL = "0"; // 正常
	public static String MEMBER_REDBAG_STATUS_DEL = "1"; // 删除
	
	// 红包使用状态
	public static String REDBAG_USESTATUS_UNCLAIMED = "0"; // 0.未领取 
	public static String REDBAG_USESTATUS_UNUSE = "1"; // 1.领取未使用
	public static String REDBAG_USESTATUS_USE = "2"; // 2. 已使用
	
	// 用户加息券使用类型
	public static String MEMBER_INTERESTCOUPON_USETYPE_0 = "0"; //0.债权投资
	// 用户红包状态
	public static String MEMBER_INTERESTCOUPON_STATUS_NORMAL = "0"; // 正常
	public static String MEMBER_INTERESTCOUPON_STATUS_DEL = "1"; // 删除
	
	// 加息券使用状态
	public static String INTERESTCOUPON_USESTATUS_UNCLAIMED = "0"; // 0.未领取 
	public static String INTERESTCOUPON_USESTATUS_UNUSE = "1"; // 1.领取未使用
	public static String INTERESTCOUPON_USESTATUS_USE = "2"; // 2. 已使用
	
	// 充值渠道来源
	public static String ACCOUNT_RECHARGE_FUIOU = "1"; // 1：富有
	public static String ACCOUNT_RECHARGE_LIANLIAN = "2"; // 2：连连
	
	// contract类型
	public static String CONTRACT_TYPE_BORROW = "1"; // 散标
	public static String CONTRACT_TYPE_PRODUCT = "2"; // 产品
	public static String CONTRACT_TYPE_TRANSFER = "3"; // 债权转让
	
	// 产品类型
	public static String PRODUCT_TYPE_1 = "1"; // 普通标
	public static String PRODUCT_TYPE_2 = "2"; // 活动标
	public static String PRODUCT_TYPE_3 = "3"; // 新手标
	
	// 散标投标状态
	public static String BORROW_TENDER_STATUS_1 = "1"; //1:正常
	public static String BORROW_TENDER_STATUS_2 = "2"; //2：撤销
	public static String BORROW_TENDER_STATUS_3 = "3"; //3:交易失败
	
	//债权转让
	public static String TRANSFER_STATUS_0 = "0";//转让中
	public static String TRANSFER_STATUS_1 = "1";//撤销
	public static String TRANSFER_STATUS_2 = "2";//转让成功
	
	//续投说
	public static String CONTINUE_INVEST_STATUS_0 = "0";//未续投
	public static String CONTINUE_INVEST_STATUS_1 = "1";//续投中
	public static String CONTINUE_INVEST_STATUS_2 = "2";//撤销
	public static String CONTINUE_INVEST_STATUS_3 = "3";//续投成功
	public static String CONTINUE_INVEST_STATUS_4 = "4";//续投失败
	
	// 次数类型
	public static String ACTIVITY_BUY_COUNT_TYPE_1 = "1";// 登录
	public static String ACTIVITY_BUY_COUNT_TYPE_2 = "2";// 分享
	
	
}
