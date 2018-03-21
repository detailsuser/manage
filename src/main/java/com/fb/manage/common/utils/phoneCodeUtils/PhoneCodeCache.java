package com.fb.manage.common.utils.phoneCodeUtils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 单个用户的手机验证码缓存
 * @createDate : 2017/11/9 16:24
 * @ceeateName : MEINANZI
 */
class PhoneCodeCache {

    /**
     *  key   验证码枚举 Enum
     *  value  内部类 PhoneCode
     */
    private Map<Enum,PhoneCode> phoneCodes = new HashMap<Enum, PhoneCode>();

    //-----------------------------------------------------------------------------------------------------------------------------

    /**
     * 保存验证码到缓存中
     * @param phoneCodeType  手机验证码类型
     * @param phoneCode  要保存的手机验证码
     */
    public void set(Enum phoneCodeType, String phoneCode){
        phoneCodes.put(phoneCodeType,new PhoneCode(phoneCode));
    }

    //-----------------------------------------------------------------------------------------------------------------------------


    /**
     * 移除缓存中的一个验证码
     * @param phoneCodeType  验证码类型枚举
     */
    public void remove(Enum phoneCodeType) {
            phoneCodes.remove(phoneCodeType);
    }

    //-----------------------------------------------------------------------------------------------------------------------------

    /**
     * 取出一个缓存中的手机验证码
     * @param phoneCodeType  验证码类型枚举
     */
    public PhoneCode get(Enum phoneCodeType){
        return phoneCodes.get(phoneCodeType);
    }

    //-----------------------------------------------------------------------------------------------------------------------------

    /**
     * 该缓存是否已经失效  用户没有验证码需要验证或者验证码都已经失效了
     * @return  true  有效<br/>
     *            false  无效
     */
    public boolean isEffective(){
        if (phoneCodes.size() == 0){
            //缓存中没有验证码存在了  已经失效
            return false;
        }
        //获取缓存中的验证码
        for (PhoneCode phoneCode : phoneCodes.values()){
            if (phoneCode.isEffective()){   //只要其中还有一个验证码是处于有效状态的，表示该缓存处于有效
                return true;
            }
        }
        return false;
    }

    //-----------------------------------------------------------------------------------------------------------------------------

    /**
     * 内部类   验证码与相关的一些属性
     */
    @Data
    class PhoneCode{
        //常量
        public static final long MIN_SEND_TIME = 1000 * 60;  //最小发送间隔
        public static final long MAX_SAVE_TIME = 1000 * 60 * 15;  //最长有效时间

        private String phoneCode;  //验证码
        private long effectiveTime;//失效时间
        private long sendTime;//发送时间

        {
            //设置发送时间
            sendTime = System.currentTimeMillis();
            //设置验证码失效时间
            effectiveTime = sendTime + MAX_SAVE_TIME;
        }
        /**
         * 构造方法
         * @param phoneCode  手机验证码
         */
        PhoneCode(String phoneCode){
            this.phoneCode = phoneCode;
        }

        /**
         * 返回当前验证码是否有效
         * @return true  有效<br>
         *          false 无效
         */
        public boolean isEffective(){
            //当前时间处于有效时间内  当前时间 < 有效时间
            if (System.currentTimeMillis() < effectiveTime ){
                return true;
            }
            return false;
        }

        /**
         * 是否可以重新发送
         * @return true  可以重发<br>
         *          false 不可以重发
         */
        public boolean isReSend(){
            //当前时间 - 发送时间 > 最小发送间隔  发送
            if (System.currentTimeMillis() - sendTime > MIN_SEND_TIME){
                return true;
            }
            return false;
        }
    }
}