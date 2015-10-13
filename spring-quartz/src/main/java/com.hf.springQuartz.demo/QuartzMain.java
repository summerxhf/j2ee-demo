package com.hf.springQuartz.demo;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:加载配置文件
 * Created  @version 1.0  2015/10/12 14:12  by xinghaifang
 */
public class QuartzMain {
    public static void main(String[] args) {
        //spring 加载配置文件.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"quzrtz-job-demo.xml"});
        context.start();
    }
}
