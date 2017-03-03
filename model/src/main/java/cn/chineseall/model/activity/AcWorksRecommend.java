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

public class AcWorksRecommend extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private Long id;

    private Long activityId;

    private Long workId;

    private Long fromOrgTreeId;

    private Long toOrgTreeId;

    private Integer score;

    private String comment;

    private Date createTime;

    private Date updateTime;

    private Integer recommendState;

    private Integer type;

    private Integer state;

    private Long juryId;

    private String juryName;
    
    public String getJuryName() {
		return juryName;
	}

	public void setJuryName(String juryName) {
		this.juryName = juryName;
	}

	public AcWorksRecommend() {
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getWorkId() {
        return this.workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public Long getFromOrgTreeId() {
        return this.fromOrgTreeId;
    }

    public void setFromOrgTreeId(Long fromOrgTreeId) {
        this.fromOrgTreeId = fromOrgTreeId;
    }

    public Long getToOrgTreeId() {
        return this.toOrgTreeId;
    }

    public void setToOrgTreeId(Long toOrgTreeId) {
        this.toOrgTreeId = toOrgTreeId;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getRecommendState() {
        return this.recommendState;
    }

    public void setRecommendState(Integer recommendState) {
        this.recommendState = recommendState;
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

    public Long getJuryId() {
        return this.juryId;
    }

    public void setJuryId(Long juryId) {
        this.juryId = juryId;
    }

}
