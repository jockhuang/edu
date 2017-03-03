package cn.chineseall.model.org;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class OrgKickoutUser extends BaseEntity {
	private static final long serialVersionUID = -6135059608432369441L;
	private Long id;
	private Long userId;
	private Long orgTreeId;
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