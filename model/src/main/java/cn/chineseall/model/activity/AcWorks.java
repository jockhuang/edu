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

import java.math.BigDecimal;
import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class AcWorks extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private Long worksId;

    private long activityId;

    private String worksName;

    private long worksGroupId;

    private long userId;

    private Long orgTreeId;

    private String orgTreeCode;

    public String getOrgTreeCode() {
		return orgTreeCode;
	}

	public void setOrgTreeCode(String orgTreeCode) {
		this.orgTreeCode = orgTreeCode;
	}
	
    private Long userOrgTreeId;

    private BigDecimal schoolscore;

    private Long schoolJuryId;

    private int flowersCount;
    
    private int dayFlowersCount;
    
    private int weekFlowersCount;
    
    private int monthFlowersCount;

    private int voteCount;

    private int auditState;

    private int pointCount;

    private int reviewCount;

    private String createdBy;
    
	private Date creationTime;

    public AcWorks() {
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    public int getDayFlowersCount() {
		return dayFlowersCount;
	}

	public void setDayFlowersCount(int dayFlowersCount) {
		this.dayFlowersCount = dayFlowersCount;
	}

	public int getWeekFlowersCount() {
		return weekFlowersCount;
	}

	public void setWeekFlowersCount(int weekFlowersCount) {
		this.weekFlowersCount = weekFlowersCount;
	}

	public int getMonthFlowersCount() {
		return monthFlowersCount;
	}

	public void setMonthFlowersCount(int monthFlowersCount) {
		this.monthFlowersCount = monthFlowersCount;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
    public Long getWorksId() {
        return this.worksId;
    }

    public void setWorksId(Long worksId) {
        this.worksId = worksId;
    }

    public long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public String getWorksName() {
        return this.worksName;
    }

    public void setWorksName(String worksName) {
        this.worksName = worksName;
    }

    public long getWorksGroupId() {
        return this.worksGroupId;
    }

    public void setWorksGroupId(long worksGroupId) {
        this.worksGroupId = worksGroupId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Long getOrgTreeId() {
        return this.orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public Long getUserOrgTreeId() {
		return userOrgTreeId;
	}

	public void setUserOrgTreeId(Long userOrgTreeId) {
		this.userOrgTreeId = userOrgTreeId;
	}

	public BigDecimal getSchoolscore() {
        return this.schoolscore;
    }

    public void setSchoolscore(BigDecimal schoolscore) {
        this.schoolscore = schoolscore;
    }

    public Long getSchoolJuryId() {
        return this.schoolJuryId;
    }

    public void setSchoolJuryId(Long schoolJuryId) {
        this.schoolJuryId = schoolJuryId;
    }

    public int getFlowersCount() {
        return this.flowersCount;
    }

    public void setFlowersCount(int flowersCount) {
        this.flowersCount = flowersCount;
    }

    public int getVoteCount() {
        return this.voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getAuditState() {
        return this.auditState;
    }

    public void setAuditState(int auditState) {
        this.auditState = auditState;
    }

    public int getPointCount() {
        return this.pointCount;
    }

    public void setPointCount(int pointCount) {
        this.pointCount = pointCount;
    }

    public int getReviewCount() {
        return this.reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

}
