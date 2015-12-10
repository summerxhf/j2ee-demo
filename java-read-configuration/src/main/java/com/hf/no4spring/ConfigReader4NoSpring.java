package com.hf.no4spring;


import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.apache.commons.configuration.ConfigurationException;
import java.io.File;
import java.util.List;

/**
 * Description:加载配置文件,不需要配置spring xml文件
 * Created  2015/12/4 10:05  by xinghaifang
 */
public class ConfigReader4NoSpring {
    protected final static Log logger = LogFactory.getLog(ConfigReader4NoSpring.class);
    //方式一:在编译阶段自动加载.
    //在编译阶段自动执行加载配置文件
    //默认加载resources文件夹下的default-config
    private static PropertiesConfiguration configuration = new PropertiesConfiguration(){
        {
            try{
                final File propertyFile = new ClassPathResource("/default-config.properties").getFile();
                logger.debug("加载配置文件"+propertyFile.getAbsolutePath());
                load(propertyFile);
            }catch(final Exception e){
                logger.error("加载配置文件出错..");
            }
        }

    };

    private ConfigReader4NoSpring(){

    }

    /**
     * 方式二:传递文件的地址来加载配置文件
     * 调用这个方法就不再默认加载default-config.
     * @param systemBasePath
     * @param path
     * @return
     */
    public static PropertiesConfiguration reloadConfiguration(final String systemBasePath ,final String path){
        configuration = new PropertiesConfiguration(){
            {
                try {
                    File propertyFile = new File(systemBasePath);
                    if(!propertyFile.exists()) {
                        propertyFile = new ClassPathResource(path).getFile();
                    }else {
                        String  filePath = systemBasePath + File.separator + path;
                        propertyFile = new File(filePath);
                    }
                    logger.debug("加载配置文件.."+propertyFile.getAbsolutePath());
                    load(propertyFile);
                } catch (final Exception e) {
                    logger.error("加载配置文件失败");
                }
            }

        };
        return configuration;
    }

    /**
     * 方式三:加载配置文件,传递参数File参数.
     * @param file
     * @return
     */
    public static boolean loadByFileType(final File file){
        try{
            configuration.load(file);
        }catch (final ConfigurationException e){
            return false;
        }
        return true;
    }

    /**
     * read key array
     * @param key
     * @return
     */
    public static String getArrayToString(final String key){
        StringBuffer sb = new StringBuffer();
        String [] values = configuration.getStringArray(key);
        if(null != values && values.length > 0){
            for(String value : values){
                sb.append(value).append(",");
            }
            return sb.toString().substring(0,sb.length()-1);
        }
        return "";
    }

    public static String[] getStringArray(final String key) {
        return configuration.getStringArray(key);
    }

    /**
     * read key string
     * @param key
     * @return
     */
    public static String get(final String key) {
        return configuration.getString(key);
    }

    /**
     * read key string and set default
     * @param key
     * @param defaultValue
     * @return
     */
    public static String get(final String key, final String defaultValue) {
        return configuration.getString(key, defaultValue);
    }

    /**
     * read key boolean
     * @param key
     * @return
     */
    public static boolean getBoolean(final String key) {
        return configuration.getBoolean(key);
    }

    /**
     * read key boolean and set default
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(final String key, final boolean defaultValue) {
        return configuration.getBoolean(key, defaultValue);
    }

    public static int getInt(final String key) {
        return configuration.getInt(key);
    }

    public static int getInt(final String key, final int defaultValue) {
        return configuration.getInt(key, defaultValue);
    }

    public static double getDouble(final String key) {
        return configuration.getDouble(key);
    }

    public static double getDouble(final String key, final double defaultValue) {
        return configuration.getDouble(key, defaultValue);
    }

    public static long getLong(final String key) {
        return configuration.getLong(key);
    }

    public static long getLong(final String key, final long defaultValue) {
        return configuration.getLong(key, defaultValue);
    }

    public static List<String> getList(final String key) {
        return configuration.getList(key);
    }

    public static List<String> getList(final String key, final List<String> defaultValue) {
        return configuration.getList(key, defaultValue);
    }



}
