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

public class AcConfig extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private long activityId;

    private int userLimit=0;

    private int worksLimit=5;

    private int wallModule=0;

    private int wallAudit=0;

    private int worksModule=0;

    private int worksAudit=0;

    private int evaluateModule=0;

    private int reviewModule=0;

    private int advertisingModule=0;

    private Integer excellentModule=0;

    private String advertisingPicture1;

    private String advertisingUrl1;

    private String advertisingPicture2;

    private String advertisingUrl2;

    private String advertisingPicture3;

    private String advertisingUrl3;

    private Date creationTime;

    private int worksGroupModule=0;

    private int excellentNumber=0;

    private int excellentPercent=0;

    private String awardSupport;

    private String awardUrl;

    private int joinLimit=1;

    private int schoolRecommend=0;

    private int cityRecommend=0;

    private int provinceRecommend=0;

    private int byFlowersScale=0;

    private int evaluateWay=0;

    private int byFlowersCount=0;

    private Integer recommendPercent;

    private Integer recommendMaxCount;

    private Integer recommendMod;
    
    private int isOrLogin=1;

    public AcConfig() {
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public int getIsOrLogin() {
		return isOrLogin;
	}

	public void setIsOrLogin(int isOrLogin) {
		this.isOrLogin = isOrLogin;
	}

	public long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public int getUserLimit() {
        return this.userLimit;
    }

    public void setUserLimit(int userLimit) {
        this.userLimit = userLimit;
    }

    public int getWorksLimit() {
        return this.worksLimit;
    }

    public void setWorksLimit(int worksLimit) {
        this.worksLimit = worksLimit;
    }

    public int getWallModule() {
        return this.wallModule;
    }

    public void setWallModule(int wallModule) {
        this.wallModule = wallModule;
    }

    public int getWallAudit() {
        return this.wallAudit;
    }

    public void setWallAudit(int wallAudit) {
        this.wallAudit = wallAudit;
    }

    public int getWorksModule() {
        return this.worksModule;
    }

    public void setWorksModule(int worksModule) {
        this.worksModule = worksModule;
    }

    public int getWorksAudit() {
        return this.worksAudit;
    }

    public void setWorksAudit(int worksAudit) {
        this.worksAudit = worksAudit;
    }

    public int getEvaluateModule() {
        return this.evaluateModule;
    }

    public void setEvaluateModule(int evaluateModule) {
        this.evaluateModule = evaluateModule;
    }

    public int getReviewModule() {
        return this.reviewModule;
    }

    public void setReviewModule(int reviewModule) {
        this.reviewModule = reviewModule;
    }

    public int getAdvertisingModule() {
        return this.advertisingModule;
    }

    public void setAdvertisingModule(int advertisingModule) {
        this.advertisingModule = advertisingModule;
    }

    public Integer getExcellentModule() {
        return this.excellentModule;
    }

    public void setExcellentModule(Integer excellentModule) {
        this.excellentModule = excellentModule;
    }

    public String getAdvertisingPicture1() {
        return this.advertisingPicture1;
    }

    public void setAdvertisingPicture1(String advertisingPicture1) {
        this.advertisingPicture1 = advertisingPicture1;
    }

    public String getAdvertisingUrl1() {
        return this.advertisingUrl1;
    }

    public void setAdvertisingUrl1(String advertisingUrl1) {
        this.advertisingUrl1 = advertisingUrl1;
    }

    public String getAdvertisingPicture2() {
        return this.advertisingPicture2;
    }

    public void setAdvertisingPicture2(String advertisingPicture2) {
        this.advertisingPicture2 = advertisingPicture2;
    }

    public String getAdvertisingUrl2() {
        return this.advertisingUrl2;
    }

    public void setAdvertisingUrl2(String advertisingUrl2) {
        this.advertisingUrl2 = advertisingUrl2;
    }

    public String getAdvertisingPicture3() {
        return this.advertisingPicture3;
    }

    public void setAdvertisingPicture3(String advertisingPicture3) {
        this.advertisingPicture3 = advertisingPicture3;
    }

    public String getAdvertisingUrl3() {
        return this.advertisingUrl3;
    }

    public void setAdvertisingUrl3(String advertisingUrl3) {
        this.advertisingUrl3 = advertisingUrl3;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public int getWorksGroupModule() {
        return this.worksGroupModule;
    }

    public void setWorksGroupModule(int worksGroupModule) {
        this.worksGroupModule = worksGroupModule;
    }

    public int getExcellentNumber() {
        return this.excellentNumber;
    }

    public void setExcellentNumber(int excellentNumber) {
        this.excellentNumber = excellentNumber;
    }

    public int getExcellentPercent() {
        return this.excellentPercent;
    }

    public void setExcellentPercent(int excellentPercent) {
        this.excellentPercent = excellentPercent;
    }

    public String getAwardSupport() {
        return this.awardSupport;
    }

    public void setAwardSupport(String awardSupport) {
        this.awardSupport = awardSupport;
    }

    public String getAwardUrl() {
        return this.awardUrl;
    }

    public void setAwardUrl(String awardUrl) {
        this.awardUrl = awardUrl;
    }

    public int getJoinLimit() {
        return this.joinLimit;
    }

    public void setJoinLimit(int joinLimit) {
        this.joinLimit = joinLimit;
    }

    public int getSchoolRecommend() {
        return this.schoolRecommend;
    }

    public void setSchoolRecommend(int schoolRecommend) {
        this.schoolRecommend = schoolRecommend;
    }

    public int getCityRecommend() {
        return this.cityRecommend;
    }

    public void setCityRecommend(int cityRecommend) {
        this.cityRecommend = cityRecommend;
    }

    public int getProvinceRecommend() {
        return this.provinceRecommend;
    }

    public void setProvinceRecommend(int provinceRecommend) {
        this.provinceRecommend = provinceRecommend;
    }

    public int getByFlowersScale() {
        return this.byFlowersScale;
    }

    public void setByFlowersScale(int byFlowersScale) {
        this.byFlowersScale = byFlowersScale;
    }

    public int getEvaluateWay() {
        return this.evaluateWay;
    }

    public void setEvaluateWay(int evaluateWay) {
        this.evaluateWay = evaluateWay;
    }

    public int getByFlowersCount() {
        return this.byFlowersCount;
    }

    public void setByFlowersCount(int byFlowersCount) {
        this.byFlowersCount = byFlowersCount;
    }

    public Integer getRecommendPercent() {
        return this.recommendPercent;
    }

    public void setRecommendPercent(Integer recommendPercent) {
        this.recommendPercent = recommendPercent;
    }

    public Integer getRecommendMaxCount() {
        return this.recommendMaxCount;
    }

    public void setRecommendMaxCount(Integer recommendMaxCount) {
        this.recommendMaxCount = recommendMaxCount;
    }

    public Integer getRecommendMod() {
        return this.recommendMod;
    }

    public void setRecommendMod(Integer recommendMod) {
        this.recommendMod = recommendMod;
    }

}
