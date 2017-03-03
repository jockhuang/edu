package cn.chineseall.book.model;

public class OrgTreeBaseinfoVo {

    private Long id;
    
    private String viewName;
    
    private String logoUrl;
    
    private String intro;
    
    private Integer isAgent=0;
    
    private Integer isView=0;
    
    private String footerContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getIsAgent() {
        return isAgent;
    }

    public void setIsAgent(Integer isAgent) {
        this.isAgent = isAgent;
    }

    public Integer getIsView() {
        return isView;
    }

    public void setIsView(Integer isView) {
        this.isView = isView;
    }

	public String getFooterContent() {
		return footerContent;
	}

	public void setFooterContent(String footerContent) {
		this.footerContent = footerContent;
	}
    
}
