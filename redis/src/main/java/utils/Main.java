package utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * Created  2016/1/22 11:27  by xinghaifang
 */
public class Main {
    public static void main(String[] args) {
        //spring 加载配置文件.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext-redis.xml"});
        context.start();

    }
}
