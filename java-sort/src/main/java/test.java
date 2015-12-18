import java.util.Random;

/**
 * Description:
 * Created  2015/12/18 17:06  by xinghaifang
 */
public class test {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        int nTemp = 0;
        Random rd = new Random();

        //1000次抽奖显示。
        for (int i = 0;i<1000;i++){
            nTemp = rd.nextInt(10000);

            System.out.println("第 "+i+" 次抽奖,中奖名次为"+nTemp);
        }
    }
}
