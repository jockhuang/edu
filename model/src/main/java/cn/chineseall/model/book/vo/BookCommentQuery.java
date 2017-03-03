/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.model.book.vo;

import java.util.List;

import cn.chineseall.model.BaseEntity;

/**
 * 
 * @author Lv15
 */
public class BookCommentQuery extends BaseEntity {

    private Long[] submiterId;

    private Long orgTreeId;

    private Long bookId;

    private Integer ifHidden;

    private Integer page;

    private List<Order> orderBy;

    public Long[] getSubmiterId() {
        return submiterId;
    }

    public void setSubmiterId(Long... submiterId) {
        this.submiterId = submiterId;
    }

    public Long getOrgTreeId() {
        return orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getIfHidden() {
        return ifHidden;
    }

    public void setIfHidden(Integer ifHidden) {
        this.ifHidden = ifHidden;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Order> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(List<Order> orderBy) {
        this.orderBy = orderBy;
    }

    public enum Order {
        ID_DESC, USEFUL_COUNT_DESC
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}

