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

public class AcWorksReview extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private Long reviewId;

    private long worksId;

    private long userId;

    private String content;

    private Date creationTime;

    private String createdBy;

    private Date lastUpdateTime;

    private String lastUpdatedBy;
    
    private Integer isSpecialist;
    
    private String userImgUrl;

    private Integer state;

    private Integer top;

    public AcWorksReview() {
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public Integer getIsSpecialist() {
		return isSpecialist;
	}

	public void setIsSpecialist(Integer isSpecialist) {
		this.isSpecialist = isSpecialist;
	}

	public Long getReviewId() {
        return this.reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public long getWorksId() {
        return this.worksId;
    }

    public void setWorksId(long worksId) {
        this.worksId = worksId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getUserImgUrl() {
        return this.userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}

}
