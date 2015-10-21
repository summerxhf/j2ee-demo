package com.hf.solr.util;

/**
 * Description:索引更新计数器.
 * Created  2015/10/16 17:57  by xinghaifang
 */
public class IndexCounter {
    private volatile long count;
    private long prevCount;

    public IndexCounter() {}

    public IndexCounter(int count) { this.count = count; }

    public synchronized long inc() {
        return ++count;
    }

    public synchronized long inc(long i) {
        count = count + i;
        return count;
    }

    public synchronized long dec() {
        return --count;
    }

    public synchronized long dec(long i) {
        count = count - i;
        return count;
    }

    /**
     * reset counter to 0
     */
    public synchronized void clear() {
        count = 0;
        prevCount = 0;
    }

    public long getCount() {
        return count;
    }

    public long getCountChange(){
        long tempCount = count;
        long change = tempCount-prevCount;
        prevCount = tempCount;
        return change;
    }
}
