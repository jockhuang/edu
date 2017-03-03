package cn.chineseall.model.audio;

import cn.chineseall.model.BaseEntity;

public class AudioInfo extends BaseEntity {

    private String chapterNo;
    private String chapterName;
    private String bookId;
    private String audioFileEnAddrCode;
    private Integer audioFileSizeNo;
    private Integer audioFileTimeLenNo;
    private Integer audioTime;
    private String audioTypeName;
    private String state;

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

    public String getAudioFileEnAddrCode() {
        return audioFileEnAddrCode;
    }

    public void setAudioFileEnAddrCode(String audioFileEnAddrCode) {
        this.audioFileEnAddrCode = audioFileEnAddrCode;
    }

    public Integer getAudioFileSizeNo() {
        return audioFileSizeNo;
    }

    public void setAudioFileSizeNo(Integer audioFileSizeNo) {
        this.audioFileSizeNo = audioFileSizeNo;
    }

    public Integer getAudioFileTimeLenNo() {
        return audioFileTimeLenNo;
    }

    public void setAudioFileTimeLenNo(Integer audioFileTimeLenNo) {
        this.audioFileTimeLenNo = audioFileTimeLenNo;
    }

    public Integer getAudioTime() {
        return audioTime;
    }

    public void setAudioTime(Integer audioTime) {
        this.audioTime = audioTime;
    }

    public String getAudioTypeName() {
        return audioTypeName;
    }

    public void setAudioTypeName(String audioTypeName) {
        this.audioTypeName = audioTypeName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    private static final long serialVersionUID = -9175782133017113988L;

}
