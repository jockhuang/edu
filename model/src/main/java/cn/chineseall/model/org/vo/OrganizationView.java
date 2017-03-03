package cn.chineseall.model.org.vo;

import cn.chineseall.model.BaseEntity;
import cn.chineseall.model.org.OrgStatistics;

public class OrganizationView extends BaseEntity{
	
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	private OrgStatisticsVo  orgSta;
	
	private String viewName;
	
	private String orgLogo;
	
	private String domainName;
	
	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}


	private Long   orgTreeId;
	
	public OrgStatisticsVo getOrgSta() {
		return orgSta;
	}

	public void setOrgSta(OrgStatisticsVo orgSta) {
		this.orgSta = orgSta;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getOrgLogo() {
		return orgLogo;
	}

	public void setOrgLogo(String orgLogo) {
		this.orgLogo = orgLogo;
	}
	
	public Long getOrgTreeId(){
		return orgTreeId;
	}
    
	public void setOrgTreeId(Long orgTreeId){
		this.orgTreeId = orgTreeId;
	}
	
	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private static final long serialVersionUID = 6026352871298491222L;

}
