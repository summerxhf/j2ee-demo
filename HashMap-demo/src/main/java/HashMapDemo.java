import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Description:java 操作map.
 * Created  2016/1/22 17:31  by xinghaifang
 */
public class HashMapDemo {
    public static void main(String[] args) {
        //向map中存入值.
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("key","value");
        for(int i = 0 ;i<66;i++){
            map.put("key"+i,"key"+i);
        }

        //1 在不知道key和value的情况下,取出map中的值.(不适用泛型)
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            Object Key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("1 循环输出key为:"+Key+" value为:"+value);
        }
        //2 使用泛型.
        Iterator<Map.Entry<String,Object>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()){
            Map.Entry<String,Object> entry = entryIterator.next();
            Object Key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("2 循环输出key为:"+Key+" value为:"+value);
        }

        //3 从map中取出某个key的值.
        Object valueObject = map.get("key");
        System.out.println("2 输出map的key为key的value值为:"+valueObject);


        //4 遍历map 效率低.是通过键来找值.
        for(Object obj:map.keySet()){
            Object valueObejct = map.get(obj);
            System.out.println("3 循环输出key为:"+obj+" value为:"+valueObejct);
        }

        //5 foreahce 循环遍历keys或者values
        for(String key :map.keySet()){
            System.out.println("Key = " + key);
        }

        for(Object value:map.values()){
            System.out.println("value = " + value);
        }

        //6 大多数使用可取的遍历方式.在遍历前先检查是否为空.
            //6.1 判断map是否为空.
        if(!map.isEmpty()){
            for(Map.Entry<String,Object> entry: map.entrySet()){
                System.out.println("key 为: " + entry.getKey() + " value = " + entry.getValue());
            }
        }


        // 7 其他方法.是否包含key 或value
        boolean flag = map.containsKey("key");
        boolean flagValue = map.containsValue("value");

        // 8 判断两个map是否相等.
        Map<Integer,Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer,Integer> map2 = new HashMap<Integer, Integer>();
        map1.put(1,1);
        map2.put(1,1);

        boolean flag2 = map1.equals(map2);
        System.out.println("输出"+flag2);

        //9 返回映射的hash码
        int hashCode = map.hashCode();

        System.out.println("hash码为: " + hashCode);

        //把map1 映射关系复制到map3中.
        Map<Integer,Integer> map3  = new HashMap<Integer, Integer>();
        map3.putAll(map1);

        //10 删除 如果存在一个key value的映射,则将其从此映射中删除.
        map.remove("key");

       //11 key value 映射关系数量
        Integer mapSize = map.size();
        System.out.println("map大小为:"+ mapSize );

        //12 在key中放入新的值,会返回旧值.

        Map<String,String> map4 = new HashMap<String,String>();
        map4.put("myKeyTest","myKeyTest");
        Object object = map4.put("myKeyTest","hhhhhh");
        System.out.print(object.toString());
    }
}
