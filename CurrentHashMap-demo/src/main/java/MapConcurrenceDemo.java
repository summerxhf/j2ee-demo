/**
 * Description:
 * Created  2016/1/27 14:31  by xinghaifang
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapConcurrenceDemo {
    private static Map<String, String> map = new ConcurrentHashMap<String, String>();
    static{
        for(int i=0;i<10;i++){
            String str = String.valueOf(i);
            map.put(str, str);
        }
    }
    public static void main(String[] args) {
//        new Thread(new MapListThread(map)).start();
//        new Thread(new MapRemoveThread(map)).start();

        final Map<String, String> map = new HashMap<String, String>();

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                for ( int i = 0; i < 10000; i++) {
                    System.out.println(i);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String  key = UUID.randomUUID().toString();
                            map.put(key, "value" + key);
                            System.out.println(map.get(key).toString());
                        }

                    }, "ftf" + i).start();
//                    System.out.println("第几次循环,循环次数为:"+i);

                }

            }

        }, "ftf");

        t.start();

        try{
            t.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

class MapListThread implements Runnable{
    private Map<String, String> map;
    public MapListThread(Map<String, String> map){
        this.map = map;
    }
    public void run() {
        Iterator<String> iter = map.values().iterator();
        while(iter.hasNext()){
            iter.next();
            System.out.println(iter.next());
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}

class MapRemoveThread implements Runnable{
    private Map<String, String> map;
    public MapRemoveThread(Map<String, String> map){
        this.map = map;
    }
    public void run() {
        for(int i=2;i<9;i++){
            String str = String.valueOf(i);
            map.remove(str);
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("Remove OK. map.size:"+map.size());
    }
}