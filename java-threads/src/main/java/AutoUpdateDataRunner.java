
/**
 * Description:具体的任务执行。
 * Created  2015/12/18 11:06  by xinghaifang
 */
public class AutoUpdateDataRunner implements Runnable {
    public  static int num = 0;
    @Override
    public void run() {
        num = num +1;
        System.out.println("第"+num+"次执行任务");
    }
}
