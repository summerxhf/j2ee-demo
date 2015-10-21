package com.hf.solr.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

import java.io.*;
import java.util.Properties;

/**
 * Description:加载配置文件,.properties.
 * Created  2015/10/16 11:58  by xinghaifang
 */
public class DecryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    private Resource[] locations;
    private String fileEncoding;

    /**
     * 设置文件编码
     * @param fileEncoding
     */
    public void setFileEncoding(String fileEncoding){
        this.fileEncoding = fileEncoding;
    }
    public void setLocations(Resource[] locations){
        this.locations = locations;
    }
    public void loadProperties(Properties properties) throws IOException{
        //可以选择加载linux服务器上的配置文件
        String systemPropertiesPath = "/etc/conf";

        //配置文件中locations的位置.
        if(this.locations!=null){
            PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();
            for (int i = 0; i <this.locations.length ; i++) {
                InputStream inputStream= null;
                Resource location = this.locations[i];
                File configDirFile = new File(systemPropertiesPath);
                //如果linux上的配置地址不存在文件
                if(!configDirFile.exists()){
                    //项目目录中的文件.
                    inputStream = this.getClass().getResourceAsStream("/config/"+location.getFilename());
                }else{
                   String filePath = systemPropertiesPath + File.separator + location.getFilename();
                   inputStream = new FileInputStream(filePath);
            }

                //设置文件编码.
                try{
                    if(fileEncoding!=null){
                        propertiesPersister.load(properties,new InputStreamReader(inputStream,fileEncoding));

                    }else {
                        propertiesPersister.load(properties,inputStream);
                    }

                    ConfigPropertiesUtil.prop = properties;
                }finally {
                    if(inputStream != null){
                        inputStream.close();
                    }
                }
            }


        }

    }

}
