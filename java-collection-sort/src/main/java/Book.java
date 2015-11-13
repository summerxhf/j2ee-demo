import java.io.Serializable;

/**
 * Description:实体
 * Created  2015/11/13 10:55  by xinghaifang
 */
public class Book implements Comparable,Serializable{

    private static final long serialVersionUID = 7834546048979821149L;
    public Integer bookId;
    public Integer bookPages;

    public Integer getBookNums() {
        return bookNums;
    }

    public void setBookNums(Integer bookNums) {
        this.bookNums = bookNums;
    }

    public Integer getBookPages() {
        return bookPages;
    }

    public void setBookPages(Integer bookPages) {
        this.bookPages = bookPages;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer bookNums;


    /**
     * @return
     */
    public int compareTo(Object object)
    {
        Book book = (Book)object;
        Integer aNum = book.getBookNums()+book.getBookNums();
        Integer bNum = this.getBookNums() + this.getBookPages();
        return aNum.compareTo(bNum);
    }

}
