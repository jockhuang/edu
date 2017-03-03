/**
 * Chineseall Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Jock
 */
package cn.chineseall.model.activity.vo;

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

    private Date creationTime;

    private String worksContent;

    private String description;

    private String pictureUrl;

    private String viewPictureUrl;

    private String smallPictureUrl;

    private String partPictureUrl;

    private String guide;

    private String schoolReviews;
    
    private String activityName;
    
    private String activityLogo;
    
    private Integer activityType;
    
    private String userName;
    
    private String phone;
    
    private String email;
    
    private String address;
    
    private Integer isSpecialist;
    
	public Integer getIsSpecialist() {
		return isSpecialist;
	}
	public void setIsSpecialist(Integer isSpecialist) {
		this.isSpecialist = isSpecialist;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String createdBy;
    
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String userImgUrl;

	private String className;
	
    private String orgTreeName;
    
    public String getUserImgUrl() {
		return userImgUrl;
	}

	public void setUserImgUrl(String userImgUrl) {
		this.userImgUrl = userImgUrl;
	}
	
    public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getOrgTreeName() {
		return orgTreeName;
	}

	public void setOrgTreeName(String orgTreeName) {
		this.orgTreeName = orgTreeName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Integer getActivityType() {
		return activityType;
	}

	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}

    public String getWorksContent() {
		return worksContent;
	}

	public void setWorksContent(String worksContent) {
		this.worksContent = worksContent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getViewPictureUrl() {
		return viewPictureUrl;
	}

	public void setViewPictureUrl(String viewPictureUrl) {
		this.viewPictureUrl = viewPictureUrl;
	}

	public String getSmallPictureUrl() {
		return smallPictureUrl;
	}

	public void setSmallPictureUrl(String smallPictureUrl) {
		this.smallPictureUrl = smallPictureUrl;
	}

	public String getPartPictureUrl() {
		return partPictureUrl;
	}

	public void setPartPictureUrl(String partPictureUrl) {
		this.partPictureUrl = partPictureUrl;
	}

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}

	public String getSchoolReviews() {
		return schoolReviews;
	}

	public void setSchoolReviews(String schoolReviews) {
		this.schoolReviews = schoolReviews;
	}
	
	public String getActivityLogo() {
		return activityLogo;
	}

	public void setActivityLogo(String activityLogo) {
		this.activityLogo = activityLogo;
	}

	public AcWorks() {
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
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
