package com.hf.solr.model;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 * Created  2015/10/16 14:53  by xinghaifang
 */
public class SearchResult<T> implements Serializable {
    public static int DEFAULlT_PAGE_SIZE = 20;
    private List<T> data;

    public long getIndexRowCount() {
        return indexRowCount;
    }

    public void setIndexRowCount(long indexRowCount) {
        this.indexRowCount = indexRowCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    private long indexRowCount;


}
