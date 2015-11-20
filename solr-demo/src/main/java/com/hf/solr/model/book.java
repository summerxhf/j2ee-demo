package com.hf.solr.model;

import org.apache.solr.client.solrj.beans.Field;

/**
 * Description:书实体.
 * Created  2015/10/16 14:43  by xinghaifang
 */
public class Book {
    @Field
    private String bookId;
    @Field
    private String bookName;
    @Field
    private String bookContent;
    @Field
    private String Author;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookContent() {
        return bookContent;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    private String bookIsbn;

}
