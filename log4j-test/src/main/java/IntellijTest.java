import org.apache.log4j.Logger;

/**
 * Description:for intellij test
 * Created  2015/11/24 06:02  by xinghaifang
 */
public class IntellijTest {
    Logger logger = Logger.getLogger(IntellijTest.class);
    public static void main(String[] args) {
        Book book = new Book();
        book.setBookName("dd");
        book.setBookId("ddd");
        IntellijTest test = new IntellijTest();
        test.logTest();

    }
    public void logTest(){
        logger.info("lucky");
        logger.info("测试");
        logger.info("测试y");
        logger.info("lucky");
        logger.info("lucky");

        logger.debug("测试log4j debug");
        logger.error("测试log4j error");
    }
}
