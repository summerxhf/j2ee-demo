/**
 * Description:
 * Created  2015/11/4 12:59  by xinghaifang
 */
public class Generic {
    public <T> T getObject(Class<T> c) throws InstantiationException,IllegalAccessException{
        //创建泛型对象.
        T t = c.newInstance();
        return t;
    }
}
