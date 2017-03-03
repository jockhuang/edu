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

public class AcWorksOperation extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private Long operationId;

    private Long workId;

    private Long userId;

    private int userAction;

    private BigDecimal score;

    private int deleteFlg;

    private String operationIp;
    
    private Date creationTime;

    private String createdBy;

    private Date lastUpdateTime;

    private String lastUpdatedBy;

    public AcWorksOperation() {
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getOperationIp() {
		return operationIp;
	}

	public void setOperationIp(String operationIp) {
		this.operationIp = operationIp;
	}

	public Long getOperationId() {
        return this.operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public long getWorkId() {
        return this.workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getUserAction() {
        return this.userAction;
    }

    public void setUserAction(int userAction) {
        this.userAction = userAction;
    }

    public BigDecimal getScore() {
        return this.score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public int getDeleteFlg() {
        return this.deleteFlg;
    }

    public void setDeleteFlg(int deleteFlg) {
        this.deleteFlg = deleteFlg;
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

    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

}
