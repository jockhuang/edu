package cn.chineseall.model.book;

import cn.chineseall.model.BaseEntity;

public class BookTxtSection extends BaseEntity {

    private Long id;
    private String name;
    private String content;
    private String sectionIndex;
    private Long chapterId;
    private Long bookId;
    private String creationTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSectionIndex() {
        return sectionIndex;
    }

    public void setSectionIndex(String sectionIndex) {
        this.sectionIndex = sectionIndex;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
    
    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}
