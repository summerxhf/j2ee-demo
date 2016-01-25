import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 * Created  2016/1/20 11:36  by xinghaifang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/*.xml"})
//@Transactional
public abstract class BaseTest {

}
