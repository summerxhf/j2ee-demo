package com.hf.solr.util;

import java.util.Properties;

/**
 * Description:读取配置文件.*.properties 工具.
 * Created  2015/10/16 16:45  by xinghaifang
 */
public class ConfigPropertiesUtil {
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
