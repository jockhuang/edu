package cn.chineseall.model.org;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class WebTemplate extends BaseEntity {
    private static final long serialVersionUID = 3148151813110962299L;
    private Integer id;
    private String name;
    private Integer orgType;
    private String content;
    private Date createTime;
    private String thumbnail;
    private Integer status;

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + this.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
