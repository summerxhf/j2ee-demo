/**
 * Description:
 * Created  2015/11/4 13:01  by xinghaifang
 */
public class GenericTest  {

    public static void main(String[]args) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        Generic generic = new Generic();
        //调用泛型方法
        Object obj = generic.getObject(Class.forName("User"));

        //判断obj的类型是否指定user类型.
        System.out.println(obj instanceof User);


    }
}
