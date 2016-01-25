import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Description:抽奖类.
 * Created  2015/12/24 13:39  by xinghaifang
 */
public class DrawLotteryDemo {

    public AwardBatch drawLottery(){
        //从db中取出抽奖表信息.
        List<AwardBatch> list = new ArrayList<AwardBatch>();

        //1 从所有奖品中获得一个奖品.
        AwardBatch awardBatch = randomGetAwardBatch(list);

        //1.1 如果奖品都发放完..
            if(awardBatch == null){
                return null;
            }
        //1.2 奖品没有发放完,随机取出一个奖品.
            //1.2.1 看是否是释放奖品的释放点.
            long nowTimestamp = System.currentTimeMillis();//当前的时间戳
            long startTimeTimestamp = new Date(nowTimestamp + 2*1000).getTime();//活动开始时间.
            long endTimeTimestamp = new Date(nowTimestamp + 2*1000).getTime();
            long timeInterval = (endTimeTimestamp - startTimeTimestamp)/awardBatch.getAmount();
            //计算下一个奖品的释放点. 总量-剩余数量
            Random random = new Random(awardBatch.getLastUpdateTime().getTime());
            long releaseTime = startTimeTimestamp + (awardBatch.getAmount() - awardBatch.getBalance())*timeInterval + Math.abs(random.nextLong())%timeInterval;

            //1.2.2 是否到释放点.
            if(nowTimestamp<releaseTime){
                return null;
            }

            //1.2.3 否则就送一个,第二个人来的话,看剩余量和时间
            //1.2.4 把这个释放时间更新到db中.
            //awardBatch.getAwardBatchId();或者在调用这个方法的时候执行中奖时间更新.
            return awardBatch;

    }

    /**
     * 从现有的奖品中随机获取一个奖品.
     * @param list
     * @return
     */
    private AwardBatch randomGetAwardBatch(List<AwardBatch> list) {
        if(list == null||list.size()<0){
            return null;
        }

        int weight = 0;//剩余奖品量.
        for(AwardBatch awardBatch :list){
            weight = weight+awardBatch.getBalance();
        }
        //奖品库中全都发放完了.
        if(weight == 0){
            return null;
        }

        //否则就随机选取一个奖品.
        Random random = new Random(weight);//获得中间的一个随机数. 如果实例化的时候有;否则取得0 到 weight -1 的随机数
        int num = random.nextInt(weight);

        /**
         * 把奖品多的先送出去,不然一等奖没了,二等奖还剩下很多.
         */
        for(AwardBatch awardBatch:list){
            num = num - awardBatch.getBalance();
            if(num<0){
                return awardBatch;
            }
        }

        throw new RuntimeException("没有奖品了.");
    }

    public static void main(String[] args) throws ParseException {
        Random random = new Random(5);
        int num = random.nextInt(5);
//        System.out.println(num);


        Random myRandom = new Random(new Date().getTime());
        System.out.println(Math.abs(myRandom.nextLong()));
        //时间戳转化为Sting或Date
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = format.format(myRandom.nextLong());
        Date date=format.parse(d);
        System.out.println("Format To String(Date):"+d);
        System.out.println("Format To Date:"+date);
//      long releaseTime = startTimeTimestamp + (awardBatch.getAmount() - awardBatch.getBalance())*timeInterval + Math.abs(myRandom.nextLong())%timeInterval;
    }

}
