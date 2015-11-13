import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:collection sort demo
 * Created  2015/11/13 10:44  by xinghaifang
 */
public class CollectionSortDemo {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<Book>();
        for(int i = 0;i<=10;i++){
            Book book  = new Book();
            if(i<5){
                book.setBookId(i);
                book.setBookNums(11+i);
                book.setBookPages(11+i);
            }else {
                book.setBookId(i);
                book.setBookNums(11-i);
                book.setBookPages(11-i);
            }
            bookList.add(book);
        }
        System.out.println("未排序--"+ bookList+ JSON.toJSONString(bookList));
        Collections.sort(bookList);
        System.out.println("排序后--"+ bookList+JSON.toJSONString(bookList));
    }

}
