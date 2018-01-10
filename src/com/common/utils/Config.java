package com.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Config {
    // 读取任务类型属性文件
    public static Properties getProperties(String fileName)  {

        Properties properties = new Properties();
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(fileName);

        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return properties;
    }
    
    public static String getString(String fileName,String paramName){
    	String str="";
    	Properties pros= getProperties(fileName);
    	str = pros.getProperty(paramName);
    	return str;
    }
}
