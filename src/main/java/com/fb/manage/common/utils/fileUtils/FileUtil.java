package com.fb.manage.common.utils.fileUtils;

import lombok.extern.log4j.Log4j;

import java.io.*;
import java.util.*;

@Log4j
public class FileUtil {
    /**
     * 创建一个文件  文件存在返回文件  不存在创建
     * @param filePath  文件路径
     * @throws Exception
     */
    public static File createFile(String filePath) throws Exception{
        //获取文件对象
        File file = new File(filePath);
        //检查文件是否存在
        if (file.exists()) {//文件或文件夹已存在
            if (file.isFile()){  //文件已存在
                return file;
            }
            //存在同名文件夹
            throw new Exception("已存在同名文件夹，文件不可创建");
        }
        //文件不存在   需要创建

        //创建文件需要有文件夹的存在
        createDirectory(file.getParent());
        //创建文件
        file.createNewFile();
        return file;
    }

    /**
     * 创建一个文件夹  如果文件夹存在不创建  不存在则创建
     * @param path 文件夹路径
     */
    public static File createDirectory(String path) throws Exception{
        File d = new File(path);
        if(d.exists()){ //文件或文件夹已存在
            if (d.isDirectory()){  //查询存在的是否为文件夹
                return d;
            }
        }else{
            if (d.mkdirs()){
                return d;
            }
         }
        return null;
    }

    /**
     * 获取文件夹路径下所有文件
     * @param path 文件夹路径
     * @return  文件夹下所有文件
     */
    public static File[] getFilesByPath(String path) throws Exception {
        //存储当前文件夹下所有文件的集合
        List<File> fList = new ArrayList<File>();
        //获取当前路径的文件对象
        File f = new File(path);
        //判断
        if (!f.exists() || !f.isDirectory()){
            throw new Exception("不存在该路径的文件夹");
        }
        //获取当前文件夹下所有的文件和文件夹
        File[] files = f.listFiles();
        if(files != null){
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()){
                    //文件夹    调用自己实现获取文件夹下的文件
                    for (File file : getFilesByPath(files[i].getPath())){
                        if (file != null) {
                            fList.add(file);
                        }
                    }
                }else{
                    //文件    保存到list中去
                    fList.add(files[i]);
                }
            }
        }
        return fList.toArray(new File[0]);
    }

    /**
     * 获取文件夹路径下所有文件夹
     * @param path 文件夹路径
     * @return  文件夹下所有文件
     */
    public static File[] getDirectorysByPath(String path) throws Exception {
        //存储当前文件夹下所有文件的集合
        List<File> fList = new ArrayList<File>();
        //获取当前路径的文件对象
        File f = new File(path);
        //判断
        if (!f.exists() || !f.isDirectory()){
            throw new Exception("不存在该路径的文件夹");
        }
        File[] files = f.listFiles();
        if(files != null){
            for (int i = 0; i < files.length; i++) {
                if ( files[i].isDirectory()){
                    //文件    保存到list中去
                    fList.add(files[i]);
                    for (File file : getDirectorysByPath(files[i].getPath())){
                        if (file != null)
                            fList.add(file);
                    }
                }
            }
        }
        return fList.toArray(new File[0]);
    }


    /**
     * 读取文件转换成字符串
     * @param file 要读取的文件
     * @return  字符串形式的 文件内的数据
     */
    public static String getStringByFile(File file)throws Exception{
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            br = new BufferedReader(new FileReader(file)) ;
            String s;
            while ((s = br.readLine()) != null){
                sb.append(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("读取文件错误",e);
        }finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


    /**
     * 将字符串写入文件
     * @param file  要写入内容的文件
     * @param append 是否追加写入
     * @return
     */
    public static File setStringToFile(File file,String s, boolean append){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file,append));
            bw.write(s);
            bw.flush();
        } catch (Exception e) {
            return null;
        } finally{
            try {
                bw.close();
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 将文件转化为二进制
     * @param file 文件
     * @return
     */
    public static byte[] getBytesByFile(File file) throws Exception {
        byte[] by = new byte[(int) file.length()];
        try {
            InputStream is = new FileInputStream(file);
            OutputStream os = new ByteArrayOutputStream();
            //缓冲区
            byte[] bb = new byte[2048];
            int ch;
            while ((ch = is.read(bb)) != -1) {
                os.write(bb, 0, ch);
            }
            by = ((ByteArrayOutputStream) os).toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("将文件转化为二进制异常",e);
        }
        return by;
    }

    /**
     * 将二进制转化为文件
     * @param bytes 二进制数组
     * @return
     */
    public static File getFileByBytes(String filePath, byte[] bytes) throws Exception {
        //创建文件
        File file = createFile(filePath);



        OutputStream os = new FileOutputStream(file);
        InputStream is = null;
        try {
             is = new ByteArrayInputStream(bytes);
            //缓冲区
            byte[] bb = new byte[2048];
            int ch;
            while ((ch = is.read(bb)) != -1) {
                os.write(bb, 0, ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("将二进制转化为文件异常",e);
        }finally {
            //关闭流
            os.flush();
            os.close();
            is.close();
        }
        return file;
    }

    /**
     * 加载配置文件
     * @param classPath 配置文件在resource下的路径
     * @return
     */
    public static Map loadPropertiesByClassPath(String classPath) throws IOException {
        InputStream is = Class.class.getClassLoader().getResourceAsStream(classPath);
        Properties properties = new Properties();
        properties.load(is);
        //将配置文件封装成map
        Map map = new HashMap();
        for (Object key : properties.keySet()){
            map.put(key,properties.getProperty((String) key));
        }
        return map;
    }













}
