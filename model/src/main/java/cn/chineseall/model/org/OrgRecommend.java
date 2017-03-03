package cn.chineseall.model.org;

// Generated 2013-4-10 17:00:54 by Hibernate Tools 3.6.0

import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * OrgRecommend generated by hbm2java
 */
public class OrgRecommend extends BaseEntity {

    private Long id;
    private Long orgTreeId;
    private long recommendOrgTreeId;
    private Integer type;
    private Integer state;
    private Date updateTime;

    public OrgRecommend() {
    }

    public OrgRecommend(long recommendOrgTreeId) {
        this.recommendOrgTreeId = recommendOrgTreeId;
    }

    public OrgRecommend(Long orgTreeId, long recommendOrgTreeId, Integer type, Integer state, Date updateTime) {
        this.orgTreeId = orgTreeId;
        this.recommendOrgTreeId = recommendOrgTreeId;
        this.type = type;
        this.state = state;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgTreeId() {
        return this.orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public long getRecommendOrgTreeId() {
        return this.recommendOrgTreeId;
    }

    public void setRecommendOrgTreeId(long recommendOrgTreeId) {
        this.recommendOrgTreeId = recommendOrgTreeId;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @see cn.chineseall.model.BaseEntity#getKeyword()
     */
    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}
