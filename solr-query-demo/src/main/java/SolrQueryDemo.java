import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Description: slolr 建立索引 删除索引 查询索引demo
 * Created  2015/10/15 15:39  by xinghaifang
 */
public class SolrQueryDemo {
    public static String solrHost = "http://localhost:8080/solr/collection1";
    protected final Log logger = LogFactory.getLog(this.getClass());
    /**
     * 添加索引.
     */
    public void addIndex(){
        //设置队列大小为215,线程数为4.
        SolrServer solrServer = new ConcurrentUpdateSolrServer(solrHost,215,4);
        try{

            SolrInputDocument document1 = new SolrInputDocument();
            document1.addField("id","1");
            document1.addField("name","xinghaifang1");

            SolrInputDocument document2 = new SolrInputDocument();
            document2.addField("id","2");
            document2.addField("name","xinghaifang2");

            SolrInputDocument document3 = new SolrInputDocument();
            document3.addField("id","3");
            document3.addField("name","xinghaifang3");

            SolrInputDocument document4 = new SolrInputDocument();
            document4.addField("id","4");
            document4.addField("name","IK Analyzer是一个结合词典分词和文法分词的中文分词开源工具包。它使用了全新的正向迭代最细粒度切分算法。");

            SolrInputDocument document5 = new SolrInputDocument();
            document5.addField("id","5");
            document5.addField("name","中国");

            Collection<SolrInputDocument> documents = new ArrayList<SolrInputDocument>();
            documents.add(document1);
            documents.add(document2);
            documents.add(document3);
            documents.add(document4);
            documents.add(document5);

            solrServer.add(documents);
            solrServer.commit();

        }catch (Exception e){
            logger.error("添加索引失败!");
        }
    }

    /**
     * 查询索引
     * @param solrServer
     * @param strSearch
     */
    public String search(SolrServer solrServer,String strSearch) throws SolrServerException {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery(strSearch);


        QueryResponse queryResponse = solrServer.query(solrQuery);
        SolrDocumentList documents = queryResponse.getResults();
        try{
            //文档个数.
            logger.info("索引中文档个数--"+documents.getNumFound());
            logger.info("查询索引使用时间--"+documents.getNumFound());

            //循环输出索引中的文档.
            for (SolrDocument document:documents){
                String documentId = (String)document.getFieldValue("id");
                String documentName = (String)document.getFieldValue("name");

                logger.info("输出文档中的id:---"+ "id:" + documentId);
                logger.info("输出文档中的name---"+"name" + documentName);

            }
        }catch (Exception e){
            logger.error("查询索引失败!请联系管理员!");
        }

        return documents.toString();
    }

    /**
     * 删除索引
     * @param solrServer
     */
    public void deleteAllIndex(SolrServer solrServer){
        try{
            //删除全部索引.
            solrServer.deleteByQuery("*:*");
            solrServer.commit();
        }catch (Exception e){
            logger.error("删除索引失败,请联系管理员!");
        }
    }



}
