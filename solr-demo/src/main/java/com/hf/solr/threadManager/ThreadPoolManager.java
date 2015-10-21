package com.hf.solr.threadManager;

import com.hf.solr.util.IndexCounter;
import com.hf.solr.util.NamedThreadFactory;
import com.hf.solr.util.PoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Created  2015/10/16 17:09  by xinghaifang
 */
public class ThreadPoolManager {
    private static Logger logger = LoggerFactory.getLogger(ThreadPoolManager.class);
    /**
     * 线程池
     */
    private ThreadPoolExecutor threadPool;


    /**
     * 监控管理
     */
    //private MonitorManager monitorManager;


    /**
     * 批量的任务
     */
//    private Map<Class<?>, IBatchTask<ISolrDoc>> batchTask = Collections.emptyMap();


    /**
     * 线程池配置
     */
    private PoolConfig poolConfig = new PoolConfig();

    /**
     * solr server的提交
     */
    private final IndexCounter solrCounter = new IndexCounter();


    /**
     * 设置线程池大小
     *
     * @param poolConfig
     */
    public void setPoolConfig(PoolConfig poolConfig) {
        this.poolConfig = poolConfig;
    }


    /**
     * 初始化
     *
     * @throws Exception
     */
    public void init() throws Exception {

        //线程池
        this.threadPool
                = new ThreadPoolExecutor(this.poolConfig.getCorePoolSize(),
                this.poolConfig.getMaxPoolSize(), this.poolConfig.getKeepAliveTime(),
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(this.poolConfig.getQueueSize()),
                new NamedThreadFactory(this.poolConfig.getPoolName()),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        logger.info("thread pool :{0}|config{1}", poolConfig.getPoolName(), poolConfig);
        logger.info("thread pool monitor init success !");

    }


    public ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }

    /**
     * 放弃的更新
     * @return
     */
    public IndexCounter getSolrCounter() {
        return solrCounter;
    }

    public void destory() {
        do {
            this.threadPool.shutdown();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                logger.error("waiting task finish fail!");
            }
        } while (!this.threadPool.isTerminated());


        logger.info("thread pool manager stopped ! ....");
    }
}
