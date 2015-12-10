package com.hf.spring;

import java.util.Properties;

/**
 * Description:读取配置文件.
 * Created  2015/12/4 11:47  by xinghaifang
 */
public class PropertiesUtil {
    public static Properties prop = new Properties();

    public static String getString(final String key) {
        return prop.getProperty(key);
    }

    public static String getString(final String key, final String defaultValue) {
        return prop.getProperty(key, defaultValue);
    }

    public static Integer getInteger(final String key, final Integer defaultValue) {
        Integer returnValue;

        String value = prop.getProperty(key);

        if(value != null && !value.trim().equals("")){
            try {
                returnValue = Integer.parseInt(value);
            } catch (Exception e) {
                returnValue = defaultValue;
            }
        }else{
            returnValue = defaultValue;
        }

        return returnValue;
    }
}
