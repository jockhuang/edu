package cn.chineseall.model.audio;

import cn.chineseall.model.BaseEntity;

public class AudioClassType extends BaseEntity {

    private String relationId;
    private String typeId;
    private String classId;

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    private static final long serialVersionUID = 368891591850693070L;
}
