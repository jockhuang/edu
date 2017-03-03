package cn.chineseall.model.org;

// Generated 2013-4-10 17:00:54 by Hibernate Tools 3.6.0

import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * OrgChoice generated by hbm2java
 */
public class OrgChoice extends BaseEntity {

    private Long id;
    private Long orgTreeId;
    private Date creationTime;

    public OrgChoice() {
    }

    public OrgChoice(Long orgTreeId, Date creationTime) {
        this.orgTreeId = orgTreeId;
        this.creationTime = creationTime;
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

    public Date getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
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
