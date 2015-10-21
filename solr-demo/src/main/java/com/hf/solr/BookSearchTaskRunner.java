package com.hf.solr;

import com.hf.solr.SpringContextHolder.SpringContextHolder;
import com.hf.solr.model.Book;
import com.hf.solr.solrManager.SolrSearchFullText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Created  2015/10/21 11:56  by xinghaifang
 */
@Service(value = "bookSearchTaskRunner")
public class BookSearchTaskRunner {
    private static Logger logger = LoggerFactory.getLogger(BookSearchTaskRunner.class);
    @Autowired
    private SolrSearchFullText solrSearchFullText;

    private static final int THREAD_KEEP_ALIVE_TIME = 300;
    private static final int THREAD_CORE_SIZE = 20;
    private static final int THREAD_MAX_SIZE = 100;
    private static final int THREAD_QUEQE_SIZE = 500;
    private ThreadPoolExecutor tpExcuter = null;
    private static int LIMIT = 30000;
    private int start = 0;

    public void run(){
        //初始化线程池.
        logger.info("初始化线程池..");
        initThreadPool();
        while (true){
            if(!buildIndex(start)){return;}
        }
    }

    private void initThreadPool() {

        tpExcuter = new ThreadPoolExecutor(THREAD_CORE_SIZE, THREAD_MAX_SIZE,
                THREAD_KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(THREAD_QUEQE_SIZE),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    private boolean buildIndex(int start){
        JdbcTemplate jdbcTemplate =  SpringContextHolder.getBean("jdbcTemplateForBar");
        String sql = "SELECT b.bar_id barId,b.bar_name barTitle,b.bar_desc barDescription , if(b.bar_img_url is null ,'' ,b.bar_img_url) barPic, if(b.last_modified_date is null ,'1970-01-01 00:00:00', b.last_modified_date) barLastModified FROM bar b " +
                " WHERE b.bar_status = 2 "+
                " ORDER BY b.create_date DESC LIMIT " + start + " ," + LIMIT;
        List<Book> searchBarDocs = jdbcTemplate.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(Book.class));
        this.start = (start + LIMIT);
        if (searchBarDocs != null && searchBarDocs.size() > 0) {
            tpExcuter.execute(new BuildBarlIndexWorkThread(searchBarDocs,solrSearchFullText));
        }else{
            return  false;
        }
        if(logger.isInfoEnabled()) {
            logger.info(" 频道定时创建时间倒序批量创建索引！ from:" + start + " to:" + (start + LIMIT));
        }
        return true;
    }
    class BuildBarlIndexWorkThread implements Runnable {
        List<Book> bookList;
        SolrSearchFullText searchApi;
        public BuildBarlIndexWorkThread(List<Book> taskList,SolrSearchFullText searchApi) {
            this.bookList = taskList;
            this.searchApi = searchApi;
        }

        @Override
        public void run() {
            searchApi.createBookIndex(bookList);
        }
    }
}
