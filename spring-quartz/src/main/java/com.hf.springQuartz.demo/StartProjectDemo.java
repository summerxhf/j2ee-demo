package com.hf.springQuartz.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**spring quartz 定时器
 * Created  @version 1.0  2015/10/12 14:52  by xinghaifang
 */
public class StartProjectDemo implements Job {

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("每五秒执行一次,执行中......");
    }
}
