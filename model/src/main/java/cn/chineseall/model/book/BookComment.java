/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.model.book;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * 
 * @author Lv15
 */
public class BookComment extends BaseEntity {

    private Long id; // 主键
    private Long bookId; // 图书id
    private String title; // 标题
    private String content; // 内容
    private Integer page; // 在哪页发表的评论
    private Long submiterId; // 提交用户id
    private Long orgTreeId; // 提交用户机构编码
    private String submiterIp; // 提交请求ip地址
    private Integer ifHidden; // 是否隐藏
    private Integer ifRecommend; // 是否推荐
    private Integer usefulCount; // 顶数
    private Integer uselessCount; // 踩数
    private Date submitTime; // 提交时间
    private Date creationTime;//入库时间
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getSubmiterId() {
        return submiterId;
    }

    public void setSubmiterId(Long submiterId) {
        this.submiterId = submiterId;
    }

    public Long getOrgTreeId() {
        return orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public String getSubmiterIp() {
        return submiterIp;
    }

    public void setSubmiterIp(String submiterIp) {
        this.submiterIp = submiterIp;
    }

    public Integer getIfHidden() {
        return ifHidden;
    }

    public void setIfHidden(Integer ifHidden) {
        this.ifHidden = ifHidden;
    }

    public Integer getIfRecommend() {
        return ifRecommend;
    }

    public void setIfRecommend(Integer ifRecommend) {
        this.ifRecommend = ifRecommend;
    }

    public Integer getUsefulCount() {
        return usefulCount;
    }

    public void setUsefulCount(Integer usefulCount) {
        this.usefulCount = usefulCount;
    }

    public Integer getUselessCount() {
        return uselessCount;
    }

    public void setUselessCount(Integer uselessCount) {
        this.uselessCount = uselessCount;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
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

    private static final long serialVersionUID = 9213907866715392410L;

}
