package cn.chineseall.model.user.vo;

import cn.chineseall.model.BaseEntity;
import cn.chineseall.model.book.Book;
import cn.chineseall.model.user.UserReadingBook;

public class UserReadingDetail extends BaseEntity {

    private UserReadingBook readingBook;

    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public UserReadingBook getReadingBook() {
        return readingBook;
    }

    public void setReadingBook(UserReadingBook readingBook) {
        this.readingBook = readingBook;
    }

    private static final long serialVersionUID = -7567260268692155907L;

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}
