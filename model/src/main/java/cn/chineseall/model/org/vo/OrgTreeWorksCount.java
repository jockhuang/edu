package cn.chineseall.model.org.vo;

import java.io.Serializable;

import cn.chineseall.model.org.OrgTree;

public class OrgTreeWorksCount implements Serializable {

	private OrgTree orgTree;

	private Long worksCount;

	public OrgTree getOrgTree() {
		return orgTree;
	}

	public void setOrgTree(OrgTree orgTree) {
		this.orgTree = orgTree;
	}

	public Long getWorksCount() {
		return worksCount;
	}

	public void setWorksCount(Long worksCount) {
		this.worksCount = worksCount;
	}

}
