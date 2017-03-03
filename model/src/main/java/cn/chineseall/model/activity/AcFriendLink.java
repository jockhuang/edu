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

public class AcFriendLink extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private Long id;

    private Long activityId;

    private String name;

    private String url;

    private String imgUrl;

    private Integer sort;

    private Integer state;

    public AcFriendLink() {
    }

    @Override
    public String getKeyword() {
        return null;
    }

    public Long getId() {
        return this.id;
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

	public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
