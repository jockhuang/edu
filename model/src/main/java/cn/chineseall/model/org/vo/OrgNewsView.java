package cn.chineseall.model.org.vo;

import cn.chineseall.model.BaseEntity;

public class OrgNewsView extends BaseEntity {

  
	private static final long serialVersionUID = -4624614631888030620L;
	private String orgViewName;     //新闻来源
    private String orgNewsTitle;    //新闻标题
    private String orgNewsContent;  //新闻内容
    private String orgNewsId;       //新闻ID
    private String creationTime;    //创建时间
    private String linkUrl;         //新闻连接
    private Long   orgTreeId;       //发布机构ID
    
	private String contentSource;   //新闻来源

    public Long getOrgTreeId() {
		return orgTreeId;
	}

	public void setOrgTreeId(Long orgTreeId) {
		this.orgTreeId = orgTreeId;
	}

	public String getOrgViewName() {
        return orgViewName;
    }

    public void setOrgViewName(String orgViewName) {
        this.orgViewName = orgViewName;
    }

    public String getOrgNewsTitle() {
        return orgNewsTitle;
    }

    public void setOrgNewsTitle(String orgNewsTitle) {
        this.orgNewsTitle = orgNewsTitle;
    }
    public String getCreationTime(){
    	return creationTime;
    }
    public void setCreationTime(String creationTime){
    	this.creationTime = creationTime;
    }
    public String getOrgNewsContent(){
    	return orgNewsContent;
    }
    public void setOrgNewsContent(String orgNewsContent){
    	this.orgNewsContent = orgNewsContent;
    }
    public String getOrgNewsId(){
    	return orgNewsId;
    }
    public void setOrgNewsId(String orgNewsId){
    	this.orgNewsId = orgNewsId;
    }
    public String getLinkUrl(){
    	return linkUrl;
    }
    public void setLinkUrl(String linkUrl){
    	this.linkUrl = linkUrl;
    }
    
    public String getContentSource() {
		return contentSource;
	}

	public void setContentSource(String contentSource) {
		this.contentSource = contentSource;
	}
    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}
