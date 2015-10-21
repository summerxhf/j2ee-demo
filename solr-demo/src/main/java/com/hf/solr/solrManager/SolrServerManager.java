package com.hf.solr.solrManager;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.util.List;

/**
 * Description:对solr操作封装.
 * Created  2015/10/16 15:28  by xinghaifang
 */
public interface SolrServerManager<T> {
    /**
     * 优化索引
     */
    public void optimizeIndex();

    /**
     * 查询索引
     * @param query
     * @return
     */
    public QueryResponse query(SolrQuery query);

    /**
     * 清理过期的索引.
     * @param minutes
     */
    public void clearExpiredDocs(long minutes);

    /**
     * 创建索引/添加索引
     * @param t
     */
    public void addBeanDocs(T t);

    /**
     * 批量添加索引.
     * @param docs
     */
    public void batchAddBeanDocs(List<T> docs);

    /**
     * 更新索引
     * @param t
     */
    public void updateBeanDocs(T t);

    /**
     * 删除索引
     * @param id
     */
    public void delBeanDocs(String id);

    /**
     * 删除索引
     * @param ids
     */
    public void delBeanDocs(List<String> ids);

    /**
     * 根据传递的string 删除索引.
     * @param strQuery
     */
    public void deleteByQuery(String strQuery);
}
