package cn.chineseall.model.audio.vo;

import cn.chineseall.model.BaseEntity;
import cn.chineseall.model.audio.AudioTypeInfo;

public class AudioTypeDetail extends BaseEntity {

    private AudioTypeInfo typeInfo;

    private Long bookCount; // 听书数量

    public AudioTypeInfo getTypeInfo() {
        return typeInfo;
    }

    public void setTypeInfo(AudioTypeInfo typeInfo) {
        this.typeInfo = typeInfo;
    }

    public Long getBookCount() {
        return bookCount;
    }

    public void setBookCount(Long bookCount) {
        this.bookCount = bookCount;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    private static final long serialVersionUID = 53588186207104645L;

}
