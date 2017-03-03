package cn.chineseall.model.audio.vo;

import java.util.List;

import cn.chineseall.model.BaseEntity;
import cn.chineseall.model.audio.AudioClassInfo;

public class AudioClassDetail extends BaseEntity {

    private AudioClassInfo classInfo;

    private List<AudioTypeDetail> childTypes;

    public List<AudioTypeDetail> getChildTypes() {
        return childTypes;
    }

    public void setChildTypes(List<AudioTypeDetail> childTypes) {
        this.childTypes = childTypes;
    }

    public AudioClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(AudioClassInfo classInfo) {
        this.classInfo = classInfo;
    }

    private static final long serialVersionUID = -7901423227779594854L;

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}
