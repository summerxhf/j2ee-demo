package com.hf.no4spring;

/**
 * Description:测试加载默认配置文件default-config.preoperties
 * Created  2015/12/4 11:04  by xinghaifang
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println("获取配置文件配置数据---"+ConfigReader4NoSpring.get("hf.test.noSpring"));

    }
}
