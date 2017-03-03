package cn.chineseall.model.org;

import cn.chineseall.model.BaseEntity;

public class PosterOrg extends BaseEntity {
	private Long id;
	private Long posterId;
	private Long orgId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPosterId() {
		return posterId;
	}

	public void setPosterId(Long posterId) {
		this.posterId = posterId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	@Override
	public String getKeyword() {
		return null;
	}
}