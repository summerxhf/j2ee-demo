import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * Description:java集合Hashtable
 * Created  2016/1/26 10:27  by xinghaifang
 */
public class HashTableDemo {
    public static void main(String[] args) {
        long start = 0;
        long end = 0;
        //1 写入
        Hashtable<String,String> hashtable = new Hashtable<String, String>();
        for(int i = 0;i<1000;i++){
            hashtable.put("key:" +i,"value:"+i);
        }

        //api 中提供了四种遍历方式.
        //　keys() - returns an Enumeration of the keys of this Hashtable
        //　keySet() - returns a Set of the keys
        //　entrySet() - returns a Set of the mappings
        //  elements() - returns an Enumeration of the values of this Hashtable
        //1 使用key遍历.
        start = System.currentTimeMillis();
        Enumeration<String> enumeration = hashtable.keys();
        while(enumeration.hasMoreElements()){

            String key = enumeration.nextElement();
            System.out.println(key);
            System.out.println(hashtable.get(key));

        }
        System. out.println( "Enumeration elements costs " + (end - start) + " milliseconds" );
        //2 使用elements()

        start = System. currentTimeMillis();
        Enumeration<String>  enumeration1 = hashtable.elements();
        while (enumeration1.hasMoreElements()){
            String value = enumeration1.nextElement();
            System.out.println("方式二"+ value);
        }
        end = System. currentTimeMillis();
        System. out.println( "Enumeration elements costs " + (end - start) + " milliseconds" );

        // 方式三使用keySet()
        start = System. currentTimeMillis();
        Iterator<String> iterator = hashtable.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            String key = iterator.next();
            System.out.println("方式三 key为:"+key + "value 为: " + hashtable.get(key));
        }

        end = System. currentTimeMillis();
        System. out.println( "Iterator keySet costs " + (end - start) + " milliseconds" );


        //方式四entrySet
        start = System. currentTimeMillis();
        Iterator<Map.Entry<String,String>> iterator1 = hashtable.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry<String,String > entry =  iterator1.next();
            System.out.println("方式四 key为:"+ entry.getKey());
            System.out.println("方式四 value为:"+ entry.getValue());
        }
        end = System. currentTimeMillis();
        System. out.println( "Iterator entrySet costs " + (end - start) + " milliseconds" );
    }
}
