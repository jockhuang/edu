package cn.chineseall.model.book.vo;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class ChapterTitle extends BaseEntity {

    private Long id;
    private Long bookId; // 文章Id
    private String name; // 章节名称
    private Integer chapterIndex; // 序号
    private Date creationTime; // 创建时间

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

    public Integer getChapterIndex() {
        return chapterIndex;
    }

    public void setChapterIndex(Integer chapterIndex) {
        this.chapterIndex = chapterIndex;
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
