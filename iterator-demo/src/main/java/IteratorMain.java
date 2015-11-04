import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description:
 * Created  2015/10/30 14:18  by xinghaifang
 */
public class IteratorMain {
    public static void main(String[] args) {
        List<Long> listBarIds =new ArrayList<Long>();
        for(long i = 0;i<900000;i++){
            listBarIds.add(i);
        }
        System.out.println("没有remove--"+listBarIds);
        long iterStart= System.currentTimeMillis();
        Iterator<Long> barIdIter = listBarIds.iterator();
        while(barIdIter.hasNext()){
            Long barId = barIdIter.next();
            if(barId.equals(55L)){
                barIdIter.remove();
            }
        }
        long iterEnd= System.currentTimeMillis();
        System.out.println("remove之后--"+listBarIds);


        List<Long> list = new ArrayList<Long>();
        for(long i = 0;i<900000;i++){
            list.add(i);
        }
        System.out.println("for 开始list"+ list);
        long forStart = System.currentTimeMillis();
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(55L)){
                list.remove(i);
            }
        }
        long forEnd = System.currentTimeMillis();
        System.out.println("for 结束list--"+list);
        System.out.println("Iterator时间--"+ (iterEnd-iterStart) + "for时间"+ (forEnd-forStart));
    }
}
