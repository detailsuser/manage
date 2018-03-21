package com.fb.manage.common.utils.object;



import com.fb.manage.common.utils.stringUtils.StringUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 对象工具
 * @createDate : 2017/12/22 10:19
 * @ceeateName : MEINANZI
 */
public class ObjectUtil {

    /**
     * 获取属性值   需要有对应的get方法
     * @param name  属性名称
     * @param obj  获取属性的对象
     * @return
     */
    public static Object getValue(String name,Object obj) throws Exception {
        //拼接get方法名
        String getMethodName= "get" + StringUtil.toUpperCase(name);
        //取出父类中的值
        return obj.getClass().getMethod(getMethodName).invoke(obj);
    }

    /**
     * 写入属性值   需要有对应的set方法
     * @param name  属性名
     * @param obj  需要写入属性值得对象
     * @param value 值对象
     * @return
     */
    public static void setValue(String name,Object obj,Object value) throws Exception {
        //拼接set方法名
        String setMethodName= "set" + StringUtil.toUpperCase(name);
        //将值写入到对象中
        if (value != null){
            obj.getClass().getMethod(setMethodName,value.getClass()).invoke(obj,value);
        }
    }

    /**
     * 使用io流对原数据进行序列化  从而对对象进行完整的拷贝
     * @param obj 需要拷贝的对象
     * @return
     */
    public static Object CloneOnIO(Object obj) {
        // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
        Object outer = null;
        try {
            // 将对象输出到对象流中
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            //将流序列化成对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            outer = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return outer;
    }

    /**
     * 将父类的属性赋值给子类
     * @param fatherObj  父类实例
     * @param sonObj  子类实例
     */
    public static void cv(final Object fatherObj, Object sonObj ) throws Exception {
        //检测是否为继承关系
        if (!fatherObj.getClass().isAssignableFrom(sonObj.getClass())){
            throw new Exception(fatherObj.getClass() + " 不是 " + sonObj.getClass() + " 的父类");
        }
        //获取父类中的所有属性
        Field[] fatherFields = getAllFields(fatherObj.getClass());
        //get父类的属性值set到子类  循环赋值
        for (Field field : fatherFields){
            //取出父类中的值   写入值到子类中去
            setValue(field.getName(),sonObj,getValue(field.getName(),fatherObj));
        }
    }


    /**
     * 获取类中的所有的属性
     * @param cls
     * @return
     */
    public static Field[] getAllFields(final Class cls){
        //存储属性的集合
        List<Field> fieldList = new ArrayList<Field>();
        Class clazz = cls ;
        //因为需要获取所有声明的字段  即包括public、private和protected  所以只能使用getDeclaredFields()方法获取
        //getDeclaredFields()方法一次只能获取某个类的所有声明的字段，不包括父类的声明字段，所以需要父类循环向上转型来获取所有的字段
        //循环获取
        while(!clazz.equals(Object.class)){
            fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fieldList.toArray(new Field[fieldList.size()]);
    }

    /**
     * 获取类中的所有的属性名
     * @param cls
     * @return
     */
    public static String[] getAllFieldsName(final Class cls) {
        Field[] fields = getAllFields(cls);
        String[] resStr = new String[fields.length];
        for (int i = 0; i < resStr.length; i++){
            resStr[i] = fields[i].getName();
        }
        return resStr;
    }

    /**
     * 比对两个对象  返回不一致的数据
     * @param obj1  被比对对象
     * @param obj2  比对对象  如果与被比对对象数据不一致  则返回该对象的数据
     * @return
     */
    public static Object notConsistentData(Object obj1, Object obj2) throws Exception {
        //验证两个对象都不为空
        if (obj1 == null || obj2 == null){
            throw new Exception("实例不能为空");
        }
        //验证两个实例类型一致
        if (!obj1.getClass().equals(obj2.getClass())){
            throw new Exception("obj1 class:" + obj1.getClass().getName() + "与 obj2 class:" + obj2.getClass().getName() + " 类型不一致");
        }
        //类
        Class cls = obj1.getClass();
        //创建一个返回实例
        Object resObj = cls.newInstance();
        //获取类中的属性名
        String[] fieldsName = getAllFieldsName(cls);
        //循环获取两个对象的属性值并比较
        for(String fieldName : fieldsName){
            //先获取比对对象的值   如果为空则不用比较
            Object value2 = getValue(fieldName,obj2);
            if (value2 == null)
                continue;
            Object value1 = getValue(fieldName,obj1);
            //如果被比较对象为空  或者  两者比较不一致  则将比对对象中的数值写入返回
            if ( value1 == null || !value1.equals(value2)){
                setValue(fieldName,resObj,value2);
            }
        }
        return resObj;
    }

    /**
     * 比对两个对象  返回一致的数据
     * @return
     */
    public static Object consistentData(Object obj1, Object obj2) throws Exception {
        //验证两个对象都不为空
        if (obj1 == null || obj2 == null){
            throw new Exception("实例不能为空");
        }
        //验证两个实例类型一致
        if (!obj1.getClass().equals(obj2.getClass())){
            throw new Exception("obj1 class:" + obj1.getClass().getName() + "与 obj2 class:" + obj2.getClass().getName() + " 类型不一致");
        }
        //类
        Class cls = obj1.getClass();
        //创建一个返回实例
        Object resObj = cls.newInstance();
        //获取类中的属性名
        String[] fieldsName = getAllFieldsName(cls);
        //循环获取两个对象的属性值
        for(String fieldName : fieldsName){
            //先获取比对对象的值
            Object value1 = getValue(fieldName,obj1);
            if (value1 == null)
                continue;
            Object value2 = getValue(fieldName,obj2);
            //如果被比较对象为空  或者  两者比较不一致  则将比对对象中的数值写入返回
            if ( value2 != null && value1.equals(value2)){
                setValue(fieldName,resObj,value2);
            }
        }
        return resObj;
    }

}
