package cn.chineseall.model.audio;

import cn.chineseall.model.BaseEntity;

public class AudioTypeInfo extends BaseEntity {

    private String typeId;
    private String typeName;
    private String description;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    private static final long serialVersionUID = -2714085762087127454L;

}
