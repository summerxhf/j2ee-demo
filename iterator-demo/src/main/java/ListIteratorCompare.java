import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description:
 * Created  2015/10/30 14:25  by xinghaifang
 */
public class ListIteratorCompare {
    public static void main(String[] args) {

        long start,end,forStart,forEnd;

        List<Integer> al=new ArrayList<Integer>();
        for(int i=0;i<9000000;i++){
            al.add(new Integer(4));
        }

        forStart= System.currentTimeMillis();
        for(int j=0;j<al.size();j++){
            al.get(j);
        }
        forEnd = System.currentTimeMillis();

        Iterator<Integer> it=al.iterator();
        start=System.currentTimeMillis();
        while(it.hasNext()){
            it.next();
        }
        end=System.currentTimeMillis();

        System.out.println("for用时:"+(forEnd-forStart)+"nIterator用时:"+(end-start));
    }
}
