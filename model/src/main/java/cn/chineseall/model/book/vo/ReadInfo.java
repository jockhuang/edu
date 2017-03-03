/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.model.book.vo;

import java.util.Map;

import cn.chineseall.model.BaseEntity;

/**
 * 阅读令牌
 * <p>
 * 提供给界面使用的vo 包含阅读模式和阅读到第几页等数据
 * </p>
 * 
 * @author Lv15
 * 
 */
public class ReadInfo extends BaseEntity {

	/**
	 * 令牌key
	 */
	private String tokenKey;

	/**
	 * 令牌内容
	 */
	private String tokenContent;

	/**
	 * 图书id
	 */
	private Long bookId;

	/**
	 * 阅读用户id
	 */
	private Long userId;

	/**
	 * 当前阅读模式
	 */
	private Integer type;

	/**
	 * 阅读第几页
	 */
	private Integer page;

	/**
	 * 阅读状态(参考ReadConstans，分为不可读，试读和全本阅读)
	 */
	private Integer func;

	/**
	 * 提供的阅读模式和每个模式阅读资源的总页数 <阅读模式 , 对应阅读资源的总页数>
	 */
	private Map<Integer, Integer> totalPageNums;

	/**
	 * 第一次阅读？
	 */
	private boolean firstRead = false;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Map<Integer, Integer> getTotalPageNums() {
		return totalPageNums;
	}

	public void setTotalPageNums(Map<Integer, Integer> totalPageNums) {
		this.totalPageNums = totalPageNums;
	}

	public Integer getFunc() {
		return func;
	}

	public void setFunc(Integer func) {
		this.func = func;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTokenContent() {
		return tokenContent;
	}

	public void setTokenContent(String tokenContent) {
		this.tokenContent = tokenContent;
	}

	public boolean isFirstRead() {
		return firstRead;
	}

	public void setFirstRead(boolean firstRead) {
		this.firstRead = firstRead;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}

}
