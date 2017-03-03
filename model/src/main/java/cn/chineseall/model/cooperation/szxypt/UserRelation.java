package cn.chineseall.model.cooperation.szxypt;

import cn.chineseall.model.BaseEntity;

public class UserRelation extends BaseEntity{
    
    private static final long serialVersionUID = 2923013977170693497L;
    
    private Long userId;
    private String relationId;
    private String note;

    @Override
    public String getKeyword() {
        return this.getClass().getName()+"."+this.getUserId();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}