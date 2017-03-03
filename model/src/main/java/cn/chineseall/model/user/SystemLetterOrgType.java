package cn.chineseall.model.user;

import cn.chineseall.model.BaseEntity;

public class SystemLetterOrgType extends BaseEntity {
	private Long id;
	private Long systemLetterId;
	private Integer orgTypeId;

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

	public Integer getOrgTypeId() {
		return orgTypeId;
	}

	public void setOrgTypeId(Integer orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}
}