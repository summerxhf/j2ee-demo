import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import utils.RedisOperateUtil;

/**
 * Description:
 * Created  2016/1/20 11:34  by xinghaifang
 */
public class RedisMain extends BaseTest {

    @Autowired
    public RedisOperateUtil redisOperateUtil;

    @Test
    public  void  testRedis(){
        redisOperateUtil.masterAdd("test",10,"test10");
        if(redisOperateUtil.hasKey("test")){
            System.out.println("输出,包含该key");
        }
    }

}
