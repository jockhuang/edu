/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.model.user.vo;

import java.util.Date;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cn.chineseall.model.BaseEntity;
import cn.chineseall.model.org.OrgTree;
import cn.chineseall.model.user.UserLevel;

/**
 * 用户基本信息，界面用户展示时使用
 * 
 * @author Lv15
 */
@Document
public class UserInfo extends BaseEntity {

	@Id
	private Long userId; // 用户id

	private String userName; // 用户账号

	private Integer identity; // 身份

	private Integer score; // 积分

	private String displayName; // 用户昵称

	private String realName; // 真实姓名

	private Integer gender; // 性别

	private Date birthday; // 生日

	private String qq; // qq号

	private String email; // 电子邮箱

	private String province; // 省

	private String city; // 市

	private String county; // 区县

	private String headImg; // 头像地址

	private UserLevel level; // 用户等级

	private List<OrgTree> orgTree; // 归属机构
	
	private boolean orgAdmin = false;	//机构管理员？

	private Object other; // 其他信息。无固定规范，按照需求放入可序列化数据(比如放入关注数据，或者访问日志等。)

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserLevel getLevel() {
		return level;
	}

	public void setLevel(UserLevel level) {
		this.level = level;
	}

	public List<OrgTree> getOrgTree() {
		return orgTree;
	}

	public void setOrgTree(List<OrgTree> orgTree) {
		this.orgTree = orgTree;
	}

	public Object getOther() {
		return other;
	}

	public void setOther(Object other) {
		this.other = other;
	}

	public boolean isOrgAdmin() {
		return orgAdmin;
	}

	public void setOrgAdmin(boolean orgAdmin) {
		this.orgAdmin = orgAdmin;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static final long serialVersionUID = 7976440707976652537L;

	

}
