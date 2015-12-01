package com.hf.solr.solrManagerImpl;

import com.hf.solr.model.Book;
import com.hf.solr.model.SearchResult;
import com.hf.solr.solrManager.SolrSearchFullText;
import com.hf.solr.solrManager.SolrServerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Description:solr全文搜索.
 * Created  2015/10/16 14:56  by xinghaifang
 */
public class SolrSearchFullTextImpl implements SolrSearchFullText {

    @Qualifier("bookSolrServer")
    @Autowired
    private SolrServerManager bookSolr;

    @Override
    public void createBookIndex(Book Book) {

    }

    @Override
    public void createBookIndex(List<Book> bookList) {

    }

    @Override
    public SearchResult queryBookIndex(String keyword, Integer start, Integer rows) {
        return null;
    }
}
