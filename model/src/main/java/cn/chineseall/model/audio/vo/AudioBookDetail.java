package cn.chineseall.model.audio.vo;

import cn.chineseall.model.BaseEntity;
import cn.chineseall.model.audio.AudioBookInfo;

public class AudioBookDetail extends BaseEntity {

    private AudioBookInfo bookInfo;
    private Integer clickCount;
    private Integer readCount;

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
    
    public AudioBookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(AudioBookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    private static final long serialVersionUID = 628353701317725701L;

}
