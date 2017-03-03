package cn.chineseall.model.org;

import cn.chineseall.model.BaseEntity;

public class PosterOrgType extends BaseEntity {
	private Long id;
	private Long posterId;
	private Integer orgTypeId;

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

	public Integer getOrgTypeId() {
		return orgTypeId;
	}

	public void setOrgTypeId(Integer orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	@Override
	public String getKeyword() {
		return null;
	}
}