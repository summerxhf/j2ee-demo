package com.hf.solr.solrManagerImpl;

import com.hf.solr.util.ConfigPropertiesUtil;
import com.hf.solr.solrManager.SolrServerManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import com.hf.solr.threadManager.ThreadPoolManager;
import org.apache.solr.client.solrj.response.UpdateResponse;

/**
 * Description:对solr基本操作的封装.
 * Created  2015/10/16 15:34  by xinghaifang
 */
public abstract class SolrServerManagerImpl<T> implements SolrServerManager<T> {
    private static Log logger = LogFactory.getLog(SolrServerManagerImpl.class);
    protected CloudSolrServer cloudSolrServer;

    //和solr配置文件中一致,通过配置文件加载.
    protected String zkHosts;//solr 集群,zookeeper ip
    protected String coreName;//solr 集群 名称.
    protected ThreadPoolManager threadPoolManager;//线程池管理,注入.
    protected String range;
    protected int optimizeThreshold = 1000;//线程最大数量是1000
    //计数器.
    protected final AtomicLong batchCounter = new AtomicLong();
    //最后批次数量.
    protected volatile long lastBatchCount = 0;

    //线程池.
    private ThreadPoolExecutor threadPoolExecutor;

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }


    public void setThreadPoolManager(ThreadPoolManager threadPoolManager){
        this.threadPoolManager = threadPoolManager;
    }
    public CloudSolrServer getCloudSolrServer() {
        return cloudSolrServer;
    }

    public void setCloudSolrServer(CloudSolrServer cloudSolrServer) {
        this.cloudSolrServer = cloudSolrServer;
    }
    public String getCoreName() {
        return coreName;
    }

    public void setCoreName(String coreName) {
        this.coreName = coreName;
    }

    public String getZkHosts() {
        return zkHosts;
    }

    public void setZkHosts(String zkHosts) {
        this.zkHosts = zkHosts;
    }
    public void setRange(String range) {
        this.range = range;
    }



    /**
     * 放在spring配置文件中,初始化函数.
     * @throws Exception
     */
    public void start() throws Exception{
        this.cloudSolrServer = new CloudSolrServer(zkHosts);
        this.cloudSolrServer.setDefaultCollection(this.coreName);//collection的名称.
        this.cloudSolrServer.setZkClientTimeout(50000);//设置zookeeper timeout
        this.cloudSolrServer.setZkConnectTimeout(10*1000);//设置zookeeper 连接超时.

        cloudSolrServer.connect();
        //从配置文件中查询,判断是否开启优化,默认不开启.
        if(Boolean.parseBoolean(ConfigPropertiesUtil.getString("search.isOpenOptimize","false"))){
            Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
                    new Runnable() {
                        @Override
                        public void run() {
                            long count = batchCounter.get();
                            long countChange = count - lastBatchCount;
                            logger.info(MessageFormat.format("time:{0},cost:{1}",new Date(),countChange));
                            //如果超过最大线程数.
                            if(countChange >= optimizeThreshold){
                                innerOptimizeIndex();
                                logger.info("");
                                lastBatchCount = count;
                            }
                        }
                    },0,5, TimeUnit.SECONDS
            );

        }

        logger.info("启动solr服务器成功!");
    }
    /**
     * 内部优化索引调用
     */
    protected void innerOptimizeIndex() {
        try {
            long now = System.currentTimeMillis();
            this.cloudSolrServer.optimize(true, false, 10);
            long eslapseTime = System.currentTimeMillis() - now;
            logger.info(MessageFormat.format("optimizeIndex|SUCC|time:{0}|cost:{1}", new Date(), eslapseTime));
        } catch (Exception e) {
            logger.error("optimizeIndex|FAIL");
        }

    }

    /**
     * 优化
     */
    @Override
    public void optimizeIndex() {
        this.threadPoolManager.getThreadPool().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        innerOptimizeIndex();
                    }
                }
        );
    }

    /**
     * 查询
     * @param query
     * @return
     */
    @Override
    public QueryResponse query(SolrQuery query) {
        QueryResponse queryResponse = null;
        try{
            queryResponse = cloudSolrServer.query(query);
        }catch (SolrServerException e){
            logger.error("查询索引失败");
        }
        return queryResponse;
    }

    /**
     * 清除所有过期的索引.
     * @param minutes
     */
    @Override
    public void clearExpiredDocs(long minutes) {

    }

    /**
     * 添加索引.
     */
    @Override
    public void addBeanDocs(T t) {
        try{
            UpdateResponse updateResponse = cloudSolrServer.addBean(t);
            cloudSolrServer.commit(false,false,true);
            if (logger.isInfoEnabled()) {
                logger.info(MessageFormat.format("addBeanDocs|SUCC|resp:{0}|{1}", updateResponse, t));
            }
            //记录器,添加索引次数.
            figureIndexUpdateCounter(1);

        }catch (Exception e){

        }
    }
    private void figureIndexUpdateCounter(int buildIndexDocNum){
        this.batchCounter.incrementAndGet();
        this.threadPoolManager.getSolrCounter().inc((long)buildIndexDocNum);
    }

    @Override
    public void batchAddBeanDocs(List<T> objects) {
        try{
            UpdateResponse updateResponse = cloudSolrServer.addBeans(objects);
            cloudSolrServer.commit(false,false,true);
            if(logger.isInfoEnabled()){
                logger.info(MessageFormat.format("batchAddBeanDocs|SUCC|resp:{0}|{1}", updateResponse, objects));
            }
            //记录更新次数.
            figureIndexUpdateCounter(objects.size());
        }catch (Exception e){
            logger.error(MessageFormat.format("batchAddBeanDocs|FAIL|{0}", objects));
        }
    }

    @Override
    public void updateBeanDocs(T t) {

    }

    /**
     * 更新索引,先删除再添加.
     * @param id
     * @param obj
     */
    public void updateBeanDocs(String id,Object obj){
        try{
            cloudSolrServer.deleteById(id);
            cloudSolrServer.commit();
            cloudSolrServer.addBean(obj);
            cloudSolrServer.commit();
            //计数.
            figureIndexUpdateCounter(1);
        }catch (Exception e){
            logger.error(MessageFormat.format("updateBeanDocs|FAIL|{0}", id));
        }
    }

    /**
     * 删除索引.
     * @param id
     */
    @Override
    public void delBeanDocs(String id) {
        try{
            cloudSolrServer.deleteById(id);
            cloudSolrServer.commit();
            if (logger.isInfoEnabled()) {
                logger.info(MessageFormat.format("deleteDocs|SUCC| ID:{0}", id));
            }
        }catch(Exception e){
            logger.error(MessageFormat.format("delBeanDocs|FAIL|{0}", id));
        }
    }


    public void delBeanDocs(List<String> ids) {
        try{
            cloudSolrServer.deleteById(ids);
            cloudSolrServer.commit();
            if (logger.isInfoEnabled()) {
                logger.info(MessageFormat.format("deleteDocs|SUCC| IDS:{0}", ids));
            }
        }catch(Exception e){
            logger.error(MessageFormat.format("batchUpdateBeanDocs|FAIL|{0}", ids));
        }
    }

    @Override
    public void deleteByQuery(String strQuery) {
        try{
            cloudSolrServer.deleteByQuery(strQuery);
            cloudSolrServer.commit();
            if (logger.isInfoEnabled()) {
                logger.info(MessageFormat.format("deleteByQuery|SUCC| query:{0}", strQuery));
            }
        }catch(Exception e){
            logger.error(MessageFormat.format("deleteByQuery|FAIL|{0}", strQuery));
        }
    }

    /**
     * 停止索引工厂. 配置文件中配置参数.
     * @throws Exception
     */
    public void destorySolrServer() throws Exception{
        this.cloudSolrServer.shutdown();
    }
}
