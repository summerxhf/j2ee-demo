package com.hf.timer.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.TimerTask;

/**
 * Description:java定时器
 * Created  @version 1.0  2015/10/12 18:29  by xinghaifang（xinghaifang@dangdang.com）
 */
public class TimerTaskDemo extends TimerTask {
    protected final Log logger = LogFactory.getLog(this.getClass());

    public String order;

    private TimerTaskDemo(){

    }

    public TimerTaskDemo(String order){
        this.order = order;
    }
    public void run(){
        try{
            logger.info("执行定时任务,每5s执行一次..."+"第--"+this.order + "--次执行");
        }catch (Exception e){
            logger.error("定时任务失败...");
        }
    }
}
