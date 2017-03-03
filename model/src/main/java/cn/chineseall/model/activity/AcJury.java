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

public class AcJury extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private Long id;

    private long groupId;

    private String groupName;

    private Long orgTreeId;

    private long juryId;

    private String juryName;

    private String juryPass;
    
	private String juryRealName;
    
    private int juryLevel;

    private long activityId;

    private Date creationTime;

    private String createdBy;

    public AcJury() {
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getJuryPass() {
		return juryPass;
	}

	public void setJuryPass(String juryPass) {
		this.juryPass = juryPass;
	}

	public String getJuryRealName() {
		return juryRealName;
	}

	public void setJuryRealName(String juryRealName) {
		this.juryRealName = juryRealName;
	}

	
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getOrgTreeId() {
        return this.orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public long getJuryId() {
        return this.juryId;
    }

    public void setJuryId(long juryId) {
        this.juryId = juryId;
    }

    public String getJuryName() {
        return this.juryName;
    }

    public void setJuryName(String juryName) {
        this.juryName = juryName;
    }

    public int getJuryLevel() {
        return this.juryLevel;
    }

    public void setJuryLevel(int juryLevel) {
        this.juryLevel = juryLevel;
    }

    public long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}
