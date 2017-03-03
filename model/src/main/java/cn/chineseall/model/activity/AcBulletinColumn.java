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

import cn.chineseall.model.BaseEntity;

public class AcBulletinColumn extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private Long id;

    private Long activityId;

    private Integer columnId;

    private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Integer getColumnId() {
		return columnId;
	}

	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}

}
