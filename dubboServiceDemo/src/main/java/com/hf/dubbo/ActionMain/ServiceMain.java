package com.hf.dubbo.ActionMain;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xinghaifang on 2015/8/26.
 * blog:http://blog.csdn.net/lovesummerforever
 */
public class ServiceMain {
    public static void main(String[] args) throws Exception{
        //加载spring配置文件.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationServer.xml"});
        context.start();
        //让服务处于一直启动状态.输入停止服务
        System.in.read();
        //测试代码
    }
}
