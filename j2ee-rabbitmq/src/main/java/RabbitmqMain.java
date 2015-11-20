import JunitBase.BaseJunit;
import hf.listener.Book;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * Description:
 * Created  2015/11/13 14:59  by xinghaifang
 */
public class RabbitmqMain extends BaseJunit {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testRqbbiqMq(){
        Book book = new Book();
        rabbitTemplate.convertAndSend("book.add", book);

//        System.out.println("addBook接口调用");
    }
}
