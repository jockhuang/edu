package cn.chineseall.model.user;

import cn.chineseall.model.BaseEntity;

public class SystemLetterUserIdentity extends BaseEntity {
	private Long id;
	private Long systemLetterId;
	private Integer userIdentity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSystemLetterId() {
		return systemLetterId;
	}

	public void setSystemLetterId(Long systemLetterId) {
		this.systemLetterId = systemLetterId;
	}

	public Integer getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(Integer userIdentity) {
		this.userIdentity = userIdentity;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}
}