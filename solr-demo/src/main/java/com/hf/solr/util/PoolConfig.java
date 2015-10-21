package com.hf.solr.util;

/**
 * Description:
 * Created  2015/10/16 17:56  by xinghaifang
 */
public class PoolConfig {
    //   核心线程数
    private int corePoolSize = 10;
    //  最大线程数
    private int maxPoolSize = 20;
    //    任务队列大小
    private int queueSize = 10 * 1000;
    // 线程池名称
    private String poolName = "TP";
    //队列长度告警阀值
    private int qlthreshold = 50;

    private long keepAliveTime = 10 * 1000;

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public void setQlthreshold(int qlthreshold) {
        this.qlthreshold = qlthreshold;
    }

    public int getQlthreshold() {
        return qlthreshold;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PoolConfig that = (PoolConfig) o;

        if (corePoolSize != that.corePoolSize) return false;
        if (maxPoolSize != that.maxPoolSize) return false;
        if (queueSize != that.queueSize) return false;
        if (poolName != null ? !poolName.equals(that.poolName) : that.poolName != null) return false;
        if (keepAliveTime != that.keepAliveTime) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = corePoolSize;
        result = 31 * result + maxPoolSize;
        result = 31 * result + queueSize;
        result = 31 * result + (poolName != null ? poolName.hashCode() : 0);
        result = 31 * result + qlthreshold;
        result = 31 * result + (int) (keepAliveTime ^ (keepAliveTime >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "PoolConfig{" +
                "corePoolSize=" + corePoolSize +
                ", maxPoolSize=" + maxPoolSize +
                ", queueSize=" + queueSize +
                ", poolName='" + poolName + '\'' +
                ", qlthreshold=" + qlthreshold +
                ", keepAliveTime=" + keepAliveTime +
                '}';
    }
}
