/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.model.user;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * 
 * @author Lv15
 */
public class UserAccount extends BaseEntity {

    /**
	 * @author MR-ZHAO
	 */
	private static final long serialVersionUID = 8640372648166173045L;
	private Long userId;
    private String displayName; // 昵称
    private String headImg; // 头像文件名称
    private Integer identity; // 身份
    private Long orgId; // 机构编码
    private Integer score; // 积分
    private String province; // 省
    private String city; // 市
    private String county; // 区县
    private String lockReason; // 锁定原因
    private Date creationTime; // 创建时间
    private Integer isSpecialist;
    private Integer yunIdentity;
    private String specialistIntro;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public Integer getIdentity() {
		return identity;
	}
	public void setIdentity(Integer identity) {
		this.identity = identity;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getLockReason() {
		return lockReason;
	}
	public void setLockReason(String lockReason) {
		this.lockReason = lockReason;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getIsSpecialist() {
		return isSpecialist;
	}
	public void setIsSpecialist(Integer isSpecialist) {
		this.isSpecialist = isSpecialist;
	}
	public Integer getYunIdentity() {
		return yunIdentity;
	}
	public void setYunIdentity(Integer yunIdentity) {
		this.yunIdentity = yunIdentity;
	}
	public String getSpecialistIntro() {
		return specialistIntro;
	}
	public void setSpecialistIntro(String specialistIntro) {
		this.specialistIntro = specialistIntro;
	}
	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}
    

}
