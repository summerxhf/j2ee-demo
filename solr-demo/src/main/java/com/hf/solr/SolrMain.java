package com.hf.solr;

import com.hf.solr.SpringContextHolder.SpringContextHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * Created  2015/10/21 14:07  by xinghaifang
 */
public class SolrMain {
    public static void main(String[] args) {
      new ClassPathXmlApplicationContext(new String[]{
                "/config/spring-db.xml"
        });
        BookSearchTaskRunner searchBarTaskRunner = SpringContextHolder.getBean("bookSearchTaskRunner");
        System.out.println("开始执行索引初始化...");
        System.out.println("开始执行索引初始化...");
        searchBarTaskRunner.run();
        System.out.println("索引结束.");
        System.out.println("输出");
        System.out.println("输出1");
        System.out.println("输出2");
        System.out.println("输出2");
        System.out.println("输出2");
        System.out.println("输出2");
        System.out.println("输出2");
        System.out.println("输出2");
        System.out.println("输出2");
        System.out.println("输出2");
        System.out.println("输出5");
        System.out.println("输出5");
        System.out.println("输出5");
        System.out.println("输出5");
        System.out.println("输出5");
    }
}
