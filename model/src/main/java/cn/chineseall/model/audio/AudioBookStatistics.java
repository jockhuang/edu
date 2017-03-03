package cn.chineseall.model.audio;

import cn.chineseall.model.BaseEntity;

public class AudioBookStatistics extends BaseEntity {

    private String bookId;
    private Integer clickCount;
    private Integer readCount;
    private String creationTime;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
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

    private static final long serialVersionUID = -5090697002742242396L;
}
