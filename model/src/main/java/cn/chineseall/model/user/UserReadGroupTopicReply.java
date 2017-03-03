package cn.chineseall.model.user;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class UserReadGroupTopicReply extends BaseEntity {

	/**
	 * @author MR-ZHAO
	 */
	private static final long serialVersionUID = -3365899518818987900L;
	private Long id;
	private Long userReadGroupTopicId;
	private String title;
	private String content;
	private Long userId;
	private Date createTime;
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserReadGroupTopicId() {
		return userReadGroupTopicId;
	}

	public void setUserReadGroupTopicId(Long userReadGroupTopicId) {
		this.userReadGroupTopicId = userReadGroupTopicId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}

}
