package cn.chineseall.model.activity;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class AcBaseinfo extends BaseEntity {

    private static final long serialVersionUID = -5735351543941972997L;
    private Long activityId;
    private String activityName;
	private Integer activityType;
    private String description;
    private String contact;
    private Long orgTreeId;
    private String orgTreeCode;
    private String logo;
    private Date startDate;
    private Date finishDate;
    private Integer activityState;
    private Integer sortNo;
    private String banner;
    private Integer bannerIndex;
    public Integer getBannerIndex() {
		return bannerIndex;
	}

	public void setBannerIndex(Integer bannerIndex) {
		this.bannerIndex = bannerIndex;
	}

	private Integer worksCount;
    private Date creationTime;
    private String createdBy;
    private Date lastUpdateTime;
    private String lastUpdatedBy;
    private String organizer;
    private Date submitStart;
    private Date submitEnd;
    private Integer submitState;

    private Integer joinUserCount;
    private Integer acBookCount;
    private Integer scoreWorksCount;
    private Integer noScoreWorksCount;
    public Integer getScoreWorksCount() {
		return scoreWorksCount;
	}

	public void setScoreWorksCount(Integer scoreWorksCount) {
		this.scoreWorksCount = scoreWorksCount;
	}

	public Integer getNoScoreWorksCount() {
		return noScoreWorksCount;
	}

	public void setNoScoreWorksCount(Integer noScoreWorksCount) {
		this.noScoreWorksCount = noScoreWorksCount;
	}

	public Integer getJoinUserCount() {
		return joinUserCount;
	}

	public void setJoinUserCount(Integer joinUserCount) {
		this.joinUserCount = joinUserCount;
	}

	public Integer getAcBookCount() {
		return acBookCount;
	}

	public void setAcBookCount(Integer acBookCount) {
		this.acBookCount = acBookCount;
	}
	
	public Long getOrgTreeId() {
		return orgTreeId;
	}

	public void setOrgTreeId(Long orgTreeId) {
		this.orgTreeId = orgTreeId;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getActivityState() {
        return activityState;
    }

    public void setActivityState(Integer activityState) {
        this.activityState = activityState;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Integer getWorksCount() {
        return worksCount;
    }

    public void setWorksCount(Integer worksCount) {
        this.worksCount = worksCount;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public Date getSubmitStart() {
        return submitStart;
    }

    public void setSubmitStart(Date submitStart) {
        this.submitStart = submitStart;
    }

    public Date getSubmitEnd() {
        return submitEnd;
    }

    public void setSubmitEnd(Date submitEnd) {
        this.submitEnd = submitEnd;
    }

    public Integer getSubmitState() {
        return submitState;
    }

    public void setSubmitState(Integer submitState) {
        this.submitState = submitState;
    }

    public String getOrgTreeCode() {
        return orgTreeCode;
    }

    public void setOrgTreeCode(String orgTreeCode) {
        this.orgTreeCode = orgTreeCode;
    }

}
