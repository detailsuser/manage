package com.fb.manage.common.utils.myBatisUtils;




import com.fb.manage.common.utils.myBatisUtils.table.MBTableField;
import com.fb.manage.common.utils.stringUtils.StringUtil;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fb.manage.common.utils.fileUtils.FileUtil.loadPropertiesByClassPath;


/**
 *
 */
public class MyBatisFactory {
    //等待提交的表
    private static Map<String , List<MBTableField>> waitingCommitTables;
    //数据库中已经存在的表
    private static Map<String , List<MBTableField>> databaseTables;

    //jdbc数据库连接配置
    private static Map properties ;


    private static Connection connection ;

    static {
        waitingCommitTables = new HashMap<String, List<MBTableField>>();
        databaseTables= new HashMap<String, List<MBTableField>>();

        //启动项目之后第一次加载 初始化
        //获取配置文件
        try {
            properties = loadPropertiesByClassPath("myBatisUtils_jdbc.properties");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取数据库连接
    private static Connection getConnect() throws Exception {
        if (connection == null){
            //获取配置文件
            Map jdbc;
            try {
                jdbc = loadPropertiesByClassPath("myBatisUtils_jdbc.properties");
            } catch (IOException e) {
                e.printStackTrace();
                throw new Exception("读取数据库连接配置为文件错误",e);
            }
            //mysql驱动
            String driver = (String) jdbc.get("jdbc.driver");
            //数据库url
            String url = (String) jdbc.get("jdbc.url");
            //MySQL的用户名
            String user = (String) jdbc.get("jdbc.username");
            //MySQL的密码
            String password = (String) jdbc.get("jdbc.password");

            // 加载驱动程序
            Class.forName(driver);
            // 连续数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            if(conn.isClosed()){
                throw new Exception("数据库连接失败");
            }
            connection = conn;
        }
        return connection;
    }



    //创建一个表
    public static void createTable(String tableName) throws Exception {
        waitingCommitTables.put(tableName,new ArrayList<MBTableField>());
        try {
            String sql = "insert into tb_dbTable (tableName) values (?)";
            PreparedStatement ps = getConnect().prepareStatement(sql);
            ps.setString(1,tableName);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
            waitingCommitTables.remove(tableName);
            throw new Exception("创建表失败",e);
        }
    }


    //表中添加一个字段
    public static void addTableField(String tableName, MBTableField MBTableField) throws Exception {
        //取出表字段
        List list = waitingCommitTables.get(tableName);
        if (list == null){
            throw new Exception("没有创建该表");
        }
        //添加字段
        list.add(MBTableField);
        //将字段保存到数据库
        String sql = "insert into tb_dbTableField () values ()";
        try{
            //sql赋值
            PreparedStatement ps = getConnect().prepareStatement(sql);
            ps.setString(1,tableName);

            //保存数据库
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("添加字段失败",e);
        }
    }



    public static File createDaoFile(File modelFile) {




        return null;
    }

    public static File createDaoImplFile(File modelFile, File daoField) {


        return null;
    }


    public static File createMapperFile(File daoField) {


        return null;
    }

    public static void commit(){

    }



        /**
         * 建表语句
         * @param tableName  表名称
         * @param fields  表字段
         * @return
         */
    public static String createDBTable(String tableName, Field[] fields){
        StringBuffer sb = new StringBuffer();

        sb.append("CREATE TABLE tb_");
        sb.append(tableName.substring(0,tableName.length()-6));
        sb.append(" ( `tableId` INT(10) NOT NULL AUTO_INCREMENT, `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, `modifyDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,");

        for(int i = 0; i < fields.length; i++){
            Field field = fields[i];

            String str = "`" + field.getName() + "` ";


             String type = DBandJAVADataTypeConversion.getDTypeByJType(field.getType().getName().toString());
            str += type;

            try {
                if (type.equals("date") || type.equals("boolean")) {

                }else if (type.equals("double")){
                    str +="(10,2)";
                }else {
                    str += "(10)";
                }
            }catch (Exception e){
                System.out.println(tableName);
                System.out.println(field.getType().getName());
            }

            sb.append(str + ",");
        }

        sb.append("PRIMARY KEY (`tableId`) );");
        return sb.toString();
    }






    /**
     *  insert 语句
     * @param className  类名
     * @param tableName  表名
     * @param fieldNames  字段名集合
     * @return
     */
    public static String Insert(String className, String tableName, List<String> fieldNames){
        //类别名
        String aliases = StringUtil.toLowerCase(className);
        StringBuffer sb = new StringBuffer();

        sb.append("<insert id=\"insert\"  useGeneratedKeys=\"true\" keyProperty=\"id\" parameterType=\" " + aliases + "\" >\n");// <insert id="insert"  useGeneratedKeys="true" keyProperty="id" parameterType="类别名" >
        sb.append("INSERT INTO " + tableName + " \n");                                                                          // INSERT INTO 表名
        sb.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n");                                                  //<trim prefix="(" suffix=")" suffixOverrides=",">
        for (String fieldName : fieldNames){sb.append("<if test=\"" + fieldName + " != null\">" + fieldName + ",</if>\n");}     //  循环  <if test="字段名 != null">字段名,</if>
        sb.append("</trim>\n");                                                                                                 //</trim>
        sb.append("VALUE\n");                                                                                                   //VALUE
        sb.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n");                                                  //<trim prefix="(" suffix=")" suffixOverrides=",">
        for (String fieldName : fieldNames){sb.append("<if test=\"" + fieldName + " != null\">#{" + fieldName + "},</if>\n");}   //  循环  <if test="字段名 != null">#{字段名},</if>}
        sb.append("</trim>\n");                                                                                                 //</trim>
        sb.append("</insert>\n");                                                                                               //</insert>

        return sb.toString();
    }


    /**
     *
     * @param className
     * @param tableName
     * @param fieldNames
     * @return
     */
    public static String InsertList(String className, String tableName, List<String> fieldNames){
        StringBuffer sb = new StringBuffer();
        String aliases = StringUtil.toLowerCase(className); //类别名

        sb.append("<insert id=\"insertList\"  useGeneratedKeys=\"true\" keyProperty=\"id\" parameterType=\" " + aliases + "\" >\n");// <insert id="insertList"  useGeneratedKeys="true" keyProperty="id" parameterType="类别名" >
        sb.append("INSERT INTO " + tableName + " \n");                                                                              // INSERT INTO 表名
        sb.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n");                                                      //<trim prefix="(" suffix=")" suffixOverrides=",">
        for (String fieldName : fieldNames){sb.append("<if test=\"" + fieldName + " != null\">" + fieldName + ",</if>\n");}         //  循环  <if test="字段名 != null">字段名,</if>
        sb.append("</trim>\n");                                                                                                     //</trim>
        sb.append("VALUE\n");                                                                                                       //VALUE
        return null;
    }



}
