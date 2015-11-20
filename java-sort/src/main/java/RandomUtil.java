import java.util.Arrays;
import java.util.Random;

/**
 * Description:获得list中前50个随机10个.并且随机10个不重复
 * Created  2015/10/28 16:09  by xinghaifang
 */
public class RandomUtil {

    private RandomUtil() {}

    private static Random rnd = null;

    /**
     * 初始化随机数发生器。
     */
    private static void initRnd() {
        if (rnd == null) rnd = new Random();
    }

    /**
     * 计算并返回无重复值的以 <code>min</code> 为下限 <code>max</code> 为上限的随机整数数组。
     * @param min 随机整数下限（包含）
     * @param max 随机整数上限（包含）
     * @param len 结果数组长度
     * @return 结果数组
     */
    public static int[] getLotteryArray(int min, int max, int len) {
        //参数校验及性能优化
        if (len < 0) return null;  //长度小于 0 的数组不存在
        if (len == 0) return new int[0];  //返回长度为 0 的数组
        if (min > max) {  //校正参数 min max
            int t = min;
            min = max;
            max = t;
        }
        final int LEN = max - min + 1;  //种子个数
        if (len > LEN) return null;  //如果出现 35 选 36 的情况就返回 null
        //计算无重复值随机数组
        initRnd();  //初始化随机数发生器
        int[] seed = new int[LEN];  //种子数组
        for (int i = 0, n = min; i < LEN;) seed[i++] = n++;  //初始化种子数组
        for (int i = 0, j = 0, t = 0; i < len; ++i) {
            j = rnd.nextInt(LEN - i) + i;
            t = seed[i];
            seed[i] = seed[j];
            seed[j] = t;
        }
        return Arrays.copyOf(seed, len);  //注意：copyOf 需要 JRE1.6
    }

    //Unit Testing
    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//...
        int[] idx = RandomUtil.getLotteryArray(0, 49, 10 /*取几个*/);
//        Integer is = new Integer[idx.length];

        System.out.print(idx.length);
        for (int i = 0;i<idx.length;i++) {
//            System.out.println(idx[i]);
        }
      /*  final int N = 10000;  //测试次数
        for (int i = 0; i < N; ++i) {
            int[] la = RandomUtil.getLotteryArray(1, 35, 7);
            if (la == null) continue;
            for (int v : la) System.out.printf("%0$02d ", v);
            System.out.println();
        }*/
    }


}
