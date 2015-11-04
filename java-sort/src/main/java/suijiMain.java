import java.util.*;

/**
 * Description:
 * Created  2015/10/28 15:59  by xinghaifang
 */
public class suijiMain {
    public static void main(String[] args) {
        Random randTest = new Random();
        for(int i = 0;i<=9;i++){
            System.out.println( randTest.nextInt(50));
        }

       /* Double num = Math.random()*50;
        System.out.print(num);*/
        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        Random rand = new Random();

        list.add(8);
        list.add(9);
        list.add(5);
        list.add(4);
        list.add(5);
        list.add(9);
        list.add(0);
        list.add(3);

        while(set.size() < 5)
        {
            set.add(list.get(rand.nextInt(list.size())));
        }

        for(Integer num: set)
        {
//            System.out.println(num);
        }
    }

}
