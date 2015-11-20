package JunitBase;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:加载配置文件基类
 * Created  2015/11/13 16:57  by xinghaifang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/*.xml"})

public abstract class BaseJunit {
    //for dao
    //@Transactional
    //@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
}
