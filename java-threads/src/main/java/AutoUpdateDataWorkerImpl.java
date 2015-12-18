import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

/**
 * Description:数据用线程批量更新。
 * Created  2015/12/17 16:32  by xinghaifang
 */
public class AutoUpdateDataWorkerImpl implements AutoUpdateDataWorker{
    protected final Log logger = LogFactory.getLog(this.getClass());

    private static int pageSize = 5;
    //最多可初始化的线程的数量。
    private  static final int THREAD_SIZE = 20;
    //线程池生命周期时间。
    private static final int THREAD_POOL_KEEP_ALIVE_TIME = 300;
    private ThreadPoolExecutor autoUpdateThreadPoolExecutor = null;
    @Override
    public void executeWork() {
        Long maxId = 1000l;
        Long minId = 10l;
        //更新数据的条数。
        long totalUpdateNums = maxId - minId;
        //初始化线程池。根据条数和每个线程池处理多少线程得到线程池数。
        initThreadPool((int) totalUpdateNums);
        int threadSize = getThreadPoolSize((int)totalUpdateNums,pageSize);

        List<AutoUpdateDataRunner> threadList = new ArrayList<AutoUpdateDataRunner>();
        for(int i=0;i<threadSize;i++){
            AutoUpdateDataRunner autoUpdateDataRunner = new AutoUpdateDataRunner();
            threadList.add(autoUpdateDataRunner);
        }

        for(AutoUpdateDataRunner runner:threadList){
            autoUpdateThreadPoolExecutor.execute(runner);
        }
    }

    /**
     * 初始化线程池。
     * @param totalUpdateNums
     */
    private void initThreadPool(int totalUpdateNums) {
        int threadSize = 1;//默认一个线程
        threadSize = getThreadPoolSize(totalUpdateNums,pageSize);
        if(threadSize>THREAD_SIZE){
            threadSize = THREAD_SIZE;
        }
        //初始化线程池，及线程池中的线程数。
        autoUpdateThreadPoolExecutor = new ThreadPoolExecutor(
                threadSize,threadSize,
                THREAD_POOL_KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(),
                new CallerRunsPolicy()
        );
    }

    /**
     * 计算开启线程数量。单个线程处理更新多少条数，总的要处理条数。
     * @param totalUpdateNums
     * @param pageSize
     * @return
     */
    private int getThreadPoolSize(int totalUpdateNums,int pageSize){
        int threadPoolSize = 0;
        if(totalUpdateNums%pageSize == 0){
            threadPoolSize = totalUpdateNums / pageSize;
        }else{
            threadPoolSize = totalUpdateNums / pageSize +1;
        }

        return threadPoolSize;
    }

    public static void main(String[] args) {
        AutoUpdateDataWorkerImpl autoUpdateDataWorker = new AutoUpdateDataWorkerImpl();
        autoUpdateDataWorker.executeWork();
    }
}
