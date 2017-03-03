package cn.chineseall.model.audio;

import cn.chineseall.model.BaseEntity;

public class AudioStatistics extends BaseEntity {

    private String chapterNo;
    private Integer readCount;

    private String creationTime;

    public String getChapterNo() {
        return chapterNo;
    }

    public void setChapterNo(String chapterNo) {
        this.chapterNo = chapterNo;
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

    private static final long serialVersionUID = 2059817374017640121L;

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}
