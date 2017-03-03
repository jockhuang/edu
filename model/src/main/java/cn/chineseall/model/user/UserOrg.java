package cn.chineseall.model.user;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class UserOrg extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8491934893246233215L;
	private Long id;
	private Long userId;
	private Long orgTreeId;
	private Integer type;
	private Integer state;
	private Date creationTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOrgTreeId() {
		return orgTreeId;
	}

	public void setOrgTreeId(Long orgTreeId) {
		this.orgTreeId = orgTreeId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String getKeyword() {
		return null;
	}
}