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

public class AcWorksExcellent extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private Long excellentId;

    private long activityId;

    private long workId;

    private Long groupId;

    private String orgTreeId;

    private int times;

    private BigDecimal score;

    private BigDecimal cityScore;

    private BigDecimal countyScore;

    private BigDecimal schoolScore;

    private Integer flowersCount;

    private Long juryId;

    private String reviews;

    private Long cityJuryId;

    private String cityReviews;

    private Long countyJuryId;

    private String countyReviews;

    private Date creationTime;

    private String createdBy;

    public AcWorksExcellent() {
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public Long getExcellentId() {
        return this.excellentId;
    }

    public void setExcellentId(Long excellentId) {
        this.excellentId = excellentId;
    }

    public long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public long getWorkId() {
        return this.workId;
    }

    public void setWorkId(long workId) {
        this.workId = workId;
    }

    public Long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getOrgTreeId() {
        return this.orgTreeId;
    }

    public void setOrgTreeId(String orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public int getTimes() {
        return this.times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public BigDecimal getScore() {
        return this.score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public BigDecimal getCityScore() {
        return this.cityScore;
    }

    public void setCityScore(BigDecimal cityScore) {
        this.cityScore = cityScore;
    }

    public BigDecimal getCountyScore() {
        return this.countyScore;
    }

    public void setCountyScore(BigDecimal countyScore) {
        this.countyScore = countyScore;
    }

    public BigDecimal getSchoolScore() {
        return this.schoolScore;
    }

    public void setSchoolScore(BigDecimal schoolScore) {
        this.schoolScore = schoolScore;
    }

    public Integer getFlowersCount() {
        return this.flowersCount;
    }

    public void setFlowersCount(Integer flowersCount) {
        this.flowersCount = flowersCount;
    }

    public Long getJuryId() {
        return this.juryId;
    }

    public void setJuryId(Long juryId) {
        this.juryId = juryId;
    }

    public String getReviews() {
        return this.reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public Long getCityJuryId() {
        return this.cityJuryId;
    }

    public void setCityJuryId(Long cityJuryId) {
        this.cityJuryId = cityJuryId;
    }

    public String getCityReviews() {
        return this.cityReviews;
    }

    public void setCityReviews(String cityReviews) {
        this.cityReviews = cityReviews;
    }

    public Long getCountyJuryId() {
        return this.countyJuryId;
    }

    public void setCountyJuryId(Long countyJuryId) {
        this.countyJuryId = countyJuryId;
    }

    public String getCountyReviews() {
        return this.countyReviews;
    }

    public void setCountyReviews(String countyReviews) {
        this.countyReviews = countyReviews;
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
