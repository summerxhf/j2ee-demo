import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Description:
 * Created  2015/10/28 15:50  by xinghaifang
 */
public class sortMain {
    public static void main(String[] args)
    {
        List<Integer> nums = new ArrayList<Integer>();
        Random rand = new Random();
        for( int i = 0; i < 40000; i++ )
        {
            nums.add( rand.nextInt(Integer.MAX_VALUE) );
        }

        long start = System.nanoTime();
        Collections.sort(nums);
        long end = System.nanoTime();

        System.out.println((end-start)/1e9);
    }
}

