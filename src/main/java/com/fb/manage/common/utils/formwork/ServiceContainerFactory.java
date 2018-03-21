package com.fb.manage.common.utils.formwork;

/**
 * 获取容器的工厂类
 * @createDate : 2017/11/14 14:47
 * @ceeateName : MEINANZI
 */
public class ServiceContainerFactory {

    private static String yy = "1970"; //年
    private static String mm = "01"; //月
    private static String dd = "01"; //日

    //申请一个服务码   并  创建一个容器
    public static ServiceContainer getServiceContainar(String userId){
        //创建一个服务申请码   当前日期  +  用户的userid  +  六位随机数
        String randmoCode = "";
        for (int i = 0; i < 6; i++){
            randmoCode = randmoCode + (int)(Math.random() * 9);
        }

        String serviceCode = yy + mm + dd +userId + randmoCode;//创建一个服务码


        System.out.println(serviceCode);
        return new ServiceContainer();
    }

    public static void main(String[] args) {
        ServiceContainerFactory.getServiceContainar("123");
    }


}
