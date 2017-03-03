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
public class UserReadGroup extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8585028695522502560L;
	private Long groupId; // 小组id
	private String groupName; // 名称
	private String logo; // logo图片
	private String introduction; // 介绍
	private Integer audit; // 加入成员是否需要审核（0-不需要审核；1-需要审核；2-拒绝加入）
	private Integer browsing; // 允许浏览（0-不允许非成员浏览；1-允许浏览）
	private Integer recommend; // 推荐权限（0-只允许管理员推荐；1-允许推荐）
	private Long userId; // 创建人用户ID
	private Date creationTime; // 创建时间
	private Integer type; // 小组类型
	private String labels; // 小组标签,以空格分开
	private Integer state; //小组状态 0:正常   1：解散
	private Integer isLively;//是否是活跃小组

	public Integer getIsLively() {
		return isLively;
	}

	public void setIsLively(Integer isLively) {
		this.isLively = isLively;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String getKeyword() {
		return this.getClass().getName()+"."+this.getGroupId();
	}

	public UserReadGroup() {
		super();
	}

	public UserReadGroup(Long groupId, String groupName, String logo,
			String introduction, Integer audit, Integer browsing,
			Integer recommend, Long userId, Date creationTime, Integer type,
			String labels) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.logo = logo;
		this.introduction = introduction;
		this.audit = audit;
		this.browsing = browsing;
		this.recommend = recommend;
		this.userId = userId;
		this.creationTime = creationTime;
		this.type = type;
		this.labels = labels;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	public Integer getBrowsing() {
		return browsing;
	}

	public void setBrowsing(Integer browsing) {
		this.browsing = browsing;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

}
