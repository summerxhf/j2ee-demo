package com.hf.spring;

import com.hf.no4spring.ConfigReader4NoSpring;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.Properties;

/**
 * Description:spring 加载配置文件,在xml中通过${}占位符显示.
 * 同时配合读取key的工具类使用,默认可以读取最后加载的文件,之前的会override
 * Created  2015/12/4 11:10  by xinghaifang
 */
public class SpringPlaceholder  extends PropertyPlaceholderConfigurer {
    private Resource[] locations;
    private  String fileEncoding;

    @Override
    public void setFileEncoding(String fileEncoding) {
        this.fileEncoding = fileEncoding;
    }
    /**
     * Set locations of properties files to be loaded.
     * <p>Can point to classic properties files or to XML files
     * that follow JDK 1.5's properties XML format.
     * <p>Note: Properties defined in later files will override
     * properties defined earlier files, in case of overlapping keys.
     * Hence, make sure that the most specific files are the last
     * ones in the given list of locations.
     */
    public void setLocations(Resource[] locations) {
        this.locations = locations;
    }


    /**
     * Load properties into the given instance.
     * @param properties the Properties instance to load into
     * @throws java.io.IOException in case of I/O errors
     * @see #setLocations
     */
    public void loadProperties(Properties properties) throws IOException{
        //系统 配置文件存放路径
        String systemConfigPath = "D:\\\testConfig";
        if(this.locations!=null){
            PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();
            for (int i = 0; i < this.locations.length; i++) {
                InputStream is = null;
                Resource location = this.locations[i];
                File configDir = new File(systemConfigPath);
                if(!configDir.exists()) {
                    is = new ClassPathResource(location.getFilename()).getInputStream();
                }else {
                    //加上分隔符,加上文件的名称.
                    String  filePath = systemConfigPath + File.separator + location.getFilename();
                    is = new FileInputStream(filePath);
                }
                try {
                    if (fileEncoding != null) {
                        propertiesPersister.load(properties, new InputStreamReader(is, fileEncoding));
                    } else {
                        propertiesPersister.load(properties, is);
                    }
                    //重新加载配置文件,为了使systemConfigPath可以读取到配置文件的类.
                    ConfigReader4NoSpring.reloadConfiguration(systemConfigPath, location.getFilename());
                    //为了使用PropertiesUtil,来读取key.
                    PropertiesUtil.prop = properties;
                } finally {
                    if (is != null) is.close();
                }
            }
        }
    }


}
