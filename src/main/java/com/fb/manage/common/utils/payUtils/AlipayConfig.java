package com.fb.manage.common.utils.payUtils;


/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：1.0
 *日期：2016-06-06
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	//合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String partner = "2088421915858148";

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBALaTVsNN1ZPFC426"+
			"DzVSgsY3nonumeOD9DrqDCH7vJIUAwN82LloqUQYaV72O9qp74mevrxwgSrYgkaz"+
			"BYQa0dPS0y4Nx8u7IAhPdv/Naa8Ck021hz5M92eYod7tLwgwY1BzQsGTxo6fBpFp"+
			"50QCn3H/PkbX+kztqd6kWmeVgWsHAgMBAAECgYEAqKHmHXYist3pEfqsWV/gkhyF"+
			"Pnk3gkE6r7/FfQ362iHJtsr1kirtTIwPpzpfhlQ3fzE0kvCHHX/ktFBd4+qxqheO"+
			"vaSEZcdmrxgO8MZf84e6KpGMNavXVPNf62FqaIdT7dQ/Qx1zFBLP7HTNOSNvG4rz"+
			"sie91IPBU6R1uYVuRIECQQDtXM57+j6G1Kzl8D58zCLzxu1j5Qw+Cn4o6urfJkFs"+
			"Lt+B7PDZjvW45kpRh0UGu1qCYTtMMXyhcrSkZ08tDU73AkEAxOlEKuyM1TzU/2ZF"+
			"h7Fqh8MlnoZnncP8sWpTeeMt6r01JDudNo/2qPjqbDCjV/NSMmHwE2N2/Ob/nbEY"+
			"U7bwcQJBAJWyVjcyV4TJVFGf9ojWZaTA7K53ogTusSo1HfOmONR1q1hRioRq+OWn"+
			"t287lHjuZ+KaV79x5lwb73lP/ks3fXkCQQCOZ7So5lIjlM7ltezq6WAFtxfpwYIG"+
			"EssY87BTIfz/Gr7n6UUVRKA6K2o9vB8laA816KZbHz/aPqT2QjE5ub/BAkBWwazH"+
			"agDi3vSNvEocQqoVjI9fV6AyhvuFuNlJcfrTWP0T2GjILKBpgJgviJ8leK82NJkc"+
			"5mDsxBUXFYdLoXhi";
	
	//支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
	
	// 签名方式
	public static String sign_type = "RSA";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path ="C://";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 接收通知的接口名
	public static String service = "mobile.securitypay.pay";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
}

