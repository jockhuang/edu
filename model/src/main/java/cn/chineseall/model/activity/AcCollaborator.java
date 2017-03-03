/**
 * Chineseall Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Jock
 */
package cn.chineseall.model.activity;

/**
 *
 * @author Jock
 */

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class AcCollaborator extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private Long collaboratorId;

    private long activityId;

    private Long orgTreeId;

    private String orgTreeName;
    
    public String getOrgTreeName() {
		return orgTreeName;
	}

	public void setOrgTreeName(String orgTreeName) {
		this.orgTreeName = orgTreeName;
	}

	private int sortNo;

    private Date creationTime;

    public AcCollaborator() {
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public Long getCollaboratorId() {
        return this.collaboratorId;
    }

    public void setCollaboratorId(Long collaboratorId) {
        this.collaboratorId = collaboratorId;
    }

    public long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public Long getOrgTreeId() {
        return this.orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public int getSortNo() {
        return this.sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

}
