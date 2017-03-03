/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.model.book.vo;

import java.util.List;

import cn.chineseall.model.BaseEntity;
import cn.chineseall.model.book.BookSelfSort;

/**
 * 自定义分类 包含图书数量，子分类列表
 * 
 * @author Lv15
 */
public class BookSelfSortDetail extends BaseEntity {

    private BookSelfSort selfSort;

    private Long bookCount; // 分类下图书数量

    private List<BookSelfSortDetail> childSelfSorts; // 子分类列表

    public Long getBookCount() {
        return bookCount;
    }

    public void setBookCount(Long bookCount) {
        this.bookCount = bookCount;
    }

    public List<BookSelfSortDetail> getChildSelfSorts() {
        return childSelfSorts;
    }

    public void setChildSelfSorts(List<BookSelfSortDetail> childSelfSorts) {
        this.childSelfSorts = childSelfSorts;
    }

    public BookSelfSort getSelfSort() {
        return selfSort;
    }

    public void setSelfSort(BookSelfSort selfSort) {
        this.selfSort = selfSort;
    }

    private static final long serialVersionUID = 8650320285602043514L;

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}
