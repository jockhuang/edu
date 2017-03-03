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
public class UserBaseinfo extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1993311163535382288L;
	private Long userId;
    private Integer isStar; // 明星书房 1：是 -1：被取消
    private String realName; // 真实姓名
    private Integer gender; // 性别 1男 2女
    private Date birthday; // 生日
    private String email; // 电子邮箱
    private String qq; // qq号
    private String country; // 国家
    private String points2011; // 荣誉积分

    /**
     * 弃用字段
     */
    private String msn;
    private String unitName;
    private String address;
    private String postcode;
    private String mobilePhone;
    private String phone;
    private String vocation;
    private String remark;
    private String secondUnitName;
    private String className;
    private String linkman;
    private String userNo;
    private Date creationTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getIsStar() {
        return isStar;
    }

    public void setIsStar(Integer isStar) {
        this.isStar = isStar;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPoints2011() {
        return points2011;
    }

    public void setPoints2011(String points2011) {
        this.points2011 = points2011;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVocation() {
        return vocation;
    }

    public void setVocation(String vocation) {
        this.vocation = vocation;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSecondUnitName() {
        return secondUnitName;
    }

    public void setSecondUnitName(String secondUnitName) {
        this.secondUnitName = secondUnitName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
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

}
