package cn.chineseall.model.audio;

import cn.chineseall.model.BaseEntity;

public class AudioBookType extends BaseEntity {

    private String relationId;
    private String bookId;
    private String typeId;

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    private static final long serialVersionUID = 6890073181404488769L;

}
