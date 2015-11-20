/**
 * Description:
 * Created  2015/11/16 18:13  by xinghaifang
 */
public class NullTest {
    public static void main(String[] args) {
        Book book = new Book();
        book.setBookId("1");
        if(book.getBookName()!=null){
            System.out.println("ok");
        }else {
            System.out.println("555");
        }
    }
}
