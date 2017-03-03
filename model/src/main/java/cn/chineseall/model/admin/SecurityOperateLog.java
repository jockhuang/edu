package cn.chineseall.model.admin;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class SecurityOperateLog extends BaseEntity {

    private Integer id;
    private Integer userId;
    private String content;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }
}
