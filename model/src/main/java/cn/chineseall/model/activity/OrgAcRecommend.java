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

public class OrgAcRecommend extends BaseEntity {

    private static final long serialVersionUID = -1L;

    private long id;

    private Long orgTreeId;

    private Long acId;

    private Integer sort;

    private Integer status;

    public OrgAcRecommend() {
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getOrgTreeId() {
        return this.orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public Long getAcId() {
        return this.acId;
    }

    public void setAcId(Long acId) {
        this.acId = acId;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
