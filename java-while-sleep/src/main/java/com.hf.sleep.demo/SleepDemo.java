package com.hf.sleep.demo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Description: while sleep来控制定时任务
 * Created  @version 1.0  2015/10/13 10:01  by xinghaifang
 */
public class SleepDemo {

    public static void main(String[] args) {
        boolean status = true;
        while (status) {
            System.out.println("每隔5秒执行一次...");
            try {
                //当前进程暂时停止5000毫秒(5秒)
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
