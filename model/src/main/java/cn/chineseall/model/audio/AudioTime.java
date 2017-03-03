package cn.chineseall.model.audio;

import cn.chineseall.model.BaseEntity;

public class AudioTime extends BaseEntity {

    private String chapterNo;
    private String chapterName;
    private String bookId;
    private Integer audioTime;

    public String getChapterNo() {
        return chapterNo;
    }

    public void setChapterNo(String chapterNo) {
        this.chapterNo = chapterNo;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Integer getAudioTime() {
        return audioTime;
    }

    public void setAudioTime(Integer audioTime) {
        this.audioTime = audioTime;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    private static final long serialVersionUID = 7979078994057300251L;

}
