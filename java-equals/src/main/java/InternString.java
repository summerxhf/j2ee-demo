/**
 * Description:
 * Created  2016/1/29 16:25  by xinghaifang
 */
public class InternString {
    public static void main(String[] args) {
//        String a ="a";
//        String b = a+ "b";
//        String c = "ab";
//        String d = new String(b);
//        System.out.println(b==c);
//        System.out.println(c==d);
//        System.out.println(c == d.intern());
//        System.out.println(b.intern() == d.intern());


        Integer a = 1;
        Integer b= 1;
        Integer c =127;
        Integer d = 127;
        System.out.println(a==b);
        System.out.println(c==d);
    }


}
