package com.hf.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * Created  2015/12/7 10:40  by xinghaifang
 */
public class MainTest {
    public static void main(String[] args) throws InterruptedException{
        String[] locations = {
                "/applicationContext-load.xml"
        };
        //一次性任务
        //时间配置:每5s执行一次<value>0/5 * * * * ?</value>
//        ApplicationContext context = new ClassPathXmlApplicationContext(locations);


        //spring 加载配置文件.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(locations);
        context.start();
        System.out.println("默认路劲中不存在--"+PropertiesUtil.getString("hf.test.spring"));
    }
}
