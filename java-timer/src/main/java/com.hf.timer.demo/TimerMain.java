package com.hf.timer.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Description:测试执行,设定时间.
 * Created  @version 1.0  2015/10/12 18:37  by xinghaifang（xinghaifang@dangdang.com）
 */
public class TimerMain {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //第一个参数TimerTask实现了TimerTask 类实现了 Runnable接口,我们自己的类TimerDemo继承TimerTask
        //第二个参数是延时,单位毫秒,下面延时是1s. 0 表示无延时
        //第三个参数是第一次调用后,从第二次开始每隔多长时间调用一次run()方法.5*1000,为5秒
        //线程运行时间为,间隔时间+固定时间
        timer.schedule(new TimerTaskDemo("1"),
                1000, 5*1000);

        //从当前日期起,每隔6毫秒之间执行
        timer.schedule(new TimerTaskDemo("2"),new Date(),5000);

//        Calendar cal = Calendar.getInstance();
//        Date date = cal.getTime();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //从某个时间开始执行任务.
        Date myDate  = new Date("2015/10/13 14:23:01");
        timer.schedule(new TimerTaskDemo("3"),myDate,5000);

    }
}
