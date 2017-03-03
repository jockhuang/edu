/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.model.user;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * @author MR-ZHAO
 */
public class UserReadGroupLabels extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1467993112652084899L;
	private Long id;
	private String labelName;
	private Date createTime;
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLabelName() {
		return labelName;
	}


	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}


}
