package cn.chineseall.model.book.vo;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class SectionTitle extends BaseEntity{
    
    private Long id;
    private Long bookId;
    private Long chapterId;
    private String name;
    private Long sectionIndex;
    private Date creationTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSectionIndex() {
        return sectionIndex;
    }

    public void setSectionIndex(Long sectionIndex) {
        this.sectionIndex = sectionIndex;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }
}
