/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Jock
 */
package cn.chineseall.model.book;

import cn.chineseall.model.BaseEntity;

/**
 * 
 * @author Jock
 */
public class Section extends BaseEntity {

    /**  */
    private static final long serialVersionUID = 8349427302499342201L;
    private long id;
    private long bookid;
    private long chapterid;
    private String name;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public long getChapterid() {
        return chapterid;
    }

    public void setChapterid(long chapterid) {
        this.chapterid = chapterid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @see cn.chineseall.model.BaseEntity#getKeyword()
     */
    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}
