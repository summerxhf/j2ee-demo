import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

/**
 * Description:
 * Created  2015/10/15 15:44  by xinghaifang
 */
public  class SolrMain {
    protected static final Log logger = LogFactory.getLog(SolrMain.class);
    public static String solrHost = "http://localhost:8080/solr/collection1";
    public static void main(String[] args) {
        //solr 服务器连接
        SolrServer solrServer = new HttpSolrServer(solrHost);

        //操作
        SolrQueryDemo solrQueryDemo = new SolrQueryDemo();
        solrQueryDemo.addIndex();//add index
        try{
            String result = solrQueryDemo.search(solrServer,"name:xinghaifang2");
            logger.info("查询出索引结果:"+result);
        }catch (Exception e){
            logger.error("查询失败.");
        }

        solrQueryDemo.deleteAllIndex(solrServer);//删除全部索引

    }
}
