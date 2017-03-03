package cn.chineseall.model.org;

// Generated 2013-4-10 17:00:54 by Hibernate Tools 3.6.0

import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * OrgNews generated by hbm2java select * from org_news where orgCode = '1447' and state = 1 and topNumber is not null
 * order by topNumber asc limit 6; select * from org_news where orgCode = '1447' order by creationTime desc limit 0,6
 * select news.* from org_news news where orgCode is null order by news.id desc limit ?
 */

public class OrgNews extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 71967036961848024L;
	private Long id;
    private Long orgTreeId; // 机构编码
    private String orgTreeCode;
    private String title; // 标题
    private String content; // 新闻内容
    private Integer clickCount; // 点击数
    private Integer state; // 状态（1正常 0隐藏 -1删除）
    private Integer isNew; // 是否最新新闻。1,是;0,否
    private Date newTimeRagne; // 最新新闻时间范围
    private Integer isPublish; // 新闻状态 。1,已发布；2已隐藏；0转发或者待处理
    private Integer isTop; // 是否置顶。 1，置顶；0，不置顶
    private Integer topNumber; // 置顶序列号。此序列号只能存储1—5几位数字之一
    private String transOrgName; // 转发机构名称
    private Integer isTrans; // 是否转发上级 1，转发，0未转发，-1,不能被处理
    private Integer newsIdentity; // 新闻来源标识，1，上级推荐新闻，2，下级推荐新闻，0标识自建新闻
    private Integer pushdown; // 推荐给所有下级
    private Long sortNo; //排序
    private String contentSource; //内容来源
    private String linkUrl; //链接地址
    private Date creationTime; // 入库时间（发布时间）

    public OrgNews() {
    }

    public OrgNews(String title) {
        this.title = title;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgTreeId() {
        return this.orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getClickCount() {
        return this.clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsNew() {
        return this.isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Date getNewTimeRagne() {
        return this.newTimeRagne;
    }

    public void setNewTimeRagne(Date newTimeRagne) {
        this.newTimeRagne = newTimeRagne;
    }

    public Integer getIsPublish() {
        return this.isPublish;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public Integer getIsTop() {
        return this.isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getTopNumber() {
        return this.topNumber;
    }

    public void setTopNumber(Integer topNumber) {
        this.topNumber = topNumber;
    }

    public String getTransOrgName() {
        return this.transOrgName;
    }

    public void setTransOrgName(String transOrgName) {
        this.transOrgName = transOrgName;
    }

    public Integer getIsTrans() {
        return this.isTrans;
    }

    public void setIsTrans(Integer isTrans) {
        this.isTrans = isTrans;
    }

    public Integer getNewsIdentity() {
        return this.newsIdentity;
    }

    public void setNewsIdentity(Integer newsIdentity) {
        this.newsIdentity = newsIdentity;
    }

    public Integer getPushdown() {
        return this.pushdown;
    }

    public void setPushdown(Integer pushdown) {
        this.pushdown = pushdown;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * @see cn.chineseall.model.BaseEntity#getKeyword()
     */
    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

	public Long getSortNo() {
		return sortNo;
	}

	public void setSortNo(Long sortNo) {
		this.sortNo = sortNo;
	}

	public String getContentSource() {
		return contentSource;
	}

	public void setContentSource(String contentSource) {
		this.contentSource = contentSource;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

    public String getOrgTreeCode() {
        return orgTreeCode;
    }

    public void setOrgTreeCode(String orgTreeCode) {
        this.orgTreeCode = orgTreeCode;
    }

}