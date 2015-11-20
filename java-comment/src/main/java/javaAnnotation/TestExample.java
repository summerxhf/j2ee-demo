package javaAnnotation;

/**
 * Description:
 * Created  2015/11/18 18:47  by xinghaifang
 */


@TesterInfo(
        priority = TesterInfo.Priority.HIGH,
        createdBy = "xhf.com",
        tags = {"sales","test" }
)
public class TestExample {

    @Test
    void testA() {
        if (true)
            throw new RuntimeException("This test always failed");
    }

    @Test(enabled = false)
    void testB() {
        if (false)
            throw new RuntimeException("This test always passed");
    }

    @Test(enabled = false)
    void testC() {
        System.out.println("shuchushuchu");
    }

    public static void main(String[] args) {
        TestExample example = new TestExample();
        example.testC();
    }

}