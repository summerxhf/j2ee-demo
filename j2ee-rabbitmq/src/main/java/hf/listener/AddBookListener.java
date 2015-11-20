package hf.listener;


/**
 * Description:
 * Created  2015/11/13 14:51  by xinghaifang
 */
public class AddBookListener {
    public void handleMessage(Book book) {
        try{
            book.setBookPages(2);
            book.setBookId(1);
            book.setBookNums(100);
            System.out.println("rabitmq 测试测试");
        }catch (Exception e){
            System.out.print("日期信息打印");
        }
    }

}
