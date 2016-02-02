/**
 * Description:关于hashCode
 * Created  2016/2/1 11:00  by xinghaifang
 */
public class HashDemo {
    public static void main(String[] args) {
        Object object = new Object();
        String strObejct = new String();
        String stObject1 = "hashcode";
        String stObject2 = "hashcode";
        String stObject3 = "hashcode1";

        System.out.println(object.hashCode());
        System.out.println(strObejct.hashCode());
        System.out.println(stObject1.hashCode());
        System.out.println(stObject2.hashCode());
        System.out.println(stObject3.hashCode());


    }

}
