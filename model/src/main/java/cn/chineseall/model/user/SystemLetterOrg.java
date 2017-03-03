package cn.chineseall.model.user;

import cn.chineseall.model.BaseEntity;

public class SystemLetterOrg extends BaseEntity {
	private Long id;
	private Long systemLetterId;
	private Long orgId;

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

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}
}