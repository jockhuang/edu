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

public class AcWorksDetail extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private long worksId;

    private String worksContent;

    private String description;

    private String pictureUrl;

    private String viewPictureUrl;

    private String smallPictureUrl;

    private String partPictureUrl;

    private String guide;

    private String schoolReviews;

    private Date creationTime;

    private String createdBy;

    private Date lastUpdateTime;

    private String lastUpdatedBy;

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public long getWorksId() {
        return this.worksId;
    }

    public void setWorksId(long worksId) {
        this.worksId = worksId;
    }

    public String getWorksContent() {
        return this.worksContent;
    }

    public void setWorksContent(String worksContent) {
        this.worksContent = worksContent;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureUrl() {
        return this.pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getViewPictureUrl() {
        return this.viewPictureUrl;
    }

    public void setViewPictureUrl(String viewPictureUrl) {
        this.viewPictureUrl = viewPictureUrl;
    }

    public String getSmallPictureUrl() {
        return this.smallPictureUrl;
    }

    public void setSmallPictureUrl(String smallPictureUrl) {
        this.smallPictureUrl = smallPictureUrl;
    }

    public String getPartPictureUrl() {
        return this.partPictureUrl;
    }

    public void setPartPictureUrl(String partPictureUrl) {
        this.partPictureUrl = partPictureUrl;
    }

    public String getGuide() {
        return this.guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getSchoolReviews() {
        return this.schoolReviews;
    }

    public void setSchoolReviews(String schoolReviews) {
        this.schoolReviews = schoolReviews;
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

}
