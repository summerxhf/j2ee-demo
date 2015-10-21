package com.hf.solr.solrManager;


import com.hf.solr.model.Book;
import com.hf.solr.model.SearchResult;

import java.util.List;

/**
 * Description:solr全文搜索
 * Created  2015/10/16 14:41  by xinghaifang
 */
public interface SolrSearchFullText {
    public void createBookIndex(Book book);
    public void createBookIndex(List<Book> bookList);
    public SearchResult queryBookIndex(String keyword,Integer start,Integer rows);
}
