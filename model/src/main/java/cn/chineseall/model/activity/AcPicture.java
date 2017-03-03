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

public class AcPicture extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private Long pictureId;

    private long activityId;

    private long groupId;

    private long userId;

    private String title;

    private String description;

    private String pictureUrl;

    private String viewPictureUrl;

    private String smallPictureUrl;

    private String partPictureUrl;

    private int auditState;

    private Date creationTime;

    private String createdBy;

    private Date lastUpdateTime;

    private String lastUpdatedBy;

    public AcPicture() {
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public Long getPictureId() {
        return this.pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getAuditState() {
        return this.auditState;
    }

    public void setAuditState(int auditState) {
        this.auditState = auditState;
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
