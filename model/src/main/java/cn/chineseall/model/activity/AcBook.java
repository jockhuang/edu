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

public class AcBook extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private Long listId;

    private long activityId;

    private long bookId;

    private int sortNo;

    private Date creationTime;

    public AcBook() {
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public Long getListId() {
        return this.listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public long getBookId() {
        return this.bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getSortNo() {
        return this.sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

}
