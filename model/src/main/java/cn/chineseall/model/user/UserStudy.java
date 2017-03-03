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
public class UserStudy extends BaseEntity {

    private Long userId;

    private String pageName;

    private Integer isCanVisitPage; // 是否允许访问书房

    private Integer isPassReadState; // 是否传递阅读状态

    private Integer isPassActivityState; // 是否传递活动状态

    private Integer isPassOtherState; // 是否传递其他状态

    private String studyStyleCss; // 书房风格

    private String curtainPicFileName; // 书房窗帘

    private Date creationTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public Integer getIsCanVisitPage() {
        return isCanVisitPage;
    }

    public void setIsCanVisitPage(Integer isCanVisitPage) {
        this.isCanVisitPage = isCanVisitPage;
    }

    public Integer getIsPassReadState() {
        return isPassReadState;
    }

    public void setIsPassReadState(Integer isPassReadState) {
        this.isPassReadState = isPassReadState;
    }

    public Integer getIsPassActivityState() {
        return isPassActivityState;
    }

    public void setIsPassActivityState(Integer isPassActivityState) {
        this.isPassActivityState = isPassActivityState;
    }

    public Integer getIsPassOtherState() {
        return isPassOtherState;
    }

    public void setIsPassOtherState(Integer isPassOtherState) {
        this.isPassOtherState = isPassOtherState;
    }

    public String getStudyStyleCss() {
        return studyStyleCss;
    }

    public void setStudyStyleCss(String studyStyleCss) {
        this.studyStyleCss = studyStyleCss;
    }

    public String getCurtainPicFileName() {
        return curtainPicFileName;
    }

    public void setCurtainPicFileName(String curtainPicFileName) {
        this.curtainPicFileName = curtainPicFileName;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    private static final long serialVersionUID = -5750750388475921582L;

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}
