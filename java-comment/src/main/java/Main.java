import org.springframework.core.annotation.Order;

/**
 * Description:
 * Created  2015/11/18 18:37  by xinghaifang
 */
@Order(value=1)
public class Main {
    @testComment
    public void testComment(){

    }

    public static void main(String[] args) {
        Main main =new Main();
        main.testComment();
    }
}
