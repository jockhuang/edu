package cn.chineseall.model.study;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserTitle")
public class UserTitle {

    private Long userId;
    
    private Integer level;
    
    //活动达人
    private Boolean isAcitvity;
    
    //书评控
    private Boolean isComment;
    
    //读书狂
    private Boolean isRead;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getIsAcitvity() {
        return isAcitvity;
    }

    public void setIsAcitvity(Boolean isAcitvity) {
        this.isAcitvity = isAcitvity;
    }

    public Boolean getIsComment() {
        return isComment;
    }

    public void setIsComment(Boolean isComment) {
        this.isComment = isComment;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}
