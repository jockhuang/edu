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
public class UserConcern extends BaseEntity {

    private Long id;

    private Long userId;

    private Long concernUserId;

    private Date concernDate;

    private Integer state;	//对方是否关注过本人（1-是 0-否）

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getConcernUserId() {
        return concernUserId;
    }

    public void setConcernUserId(Long concernUserId) {
        this.concernUserId = concernUserId;
    }

    public Date getConcernDate() {
        return concernDate;
    }

    public void setConcernDate(Date concernDate) {
        this.concernDate = concernDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}
