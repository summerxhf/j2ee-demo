/**
 * Description:
 * Created  2016/1/29 15:37  by xinghaifang
 */
public class EqualsDemo {
    public static void main(String[] args) {
        String c = "1";
        String a = "a"+"b"+c;
        String d = "a"+"b"+1;
        String b = "ab1";

        System.out.println(a == b);
        System.out.println(a == d);
    }

}
