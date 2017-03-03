package cn.chineseall.model.audio;

import cn.chineseall.model.BaseEntity;

public class AudioClassInfo extends BaseEntity {

    private String classId;
    private String className;
    private String description;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private static final long serialVersionUID = 2529406596630454622L;

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}
