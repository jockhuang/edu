package cn.chineseall.model.content;

import cn.chineseall.model.BaseEntity;

public class WebBookContent extends BaseEntity {

	private static final long serialVersionUID = -5497349143685828531L;
	
	private Long id;
	private Long bookId;
	private Integer type;
	private Long orgTypeId;
	private Integer recommendType;
	private Long orgTreeId;
	private String name;
	private String linkUrl;
	private String intro;
	private Integer sort;
	private String author;
	private String imageUrl;
	private String publisher;
	private Integer status;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getOrgTypeId() {
		return orgTypeId;
	}

	public void setOrgTypeId(Long orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	public Long getOrgTreeId() {
		return orgTreeId;
	}

	public void setOrgTreeId(Long orgTreeId) {
		this.orgTreeId = orgTreeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String getKeyword() {
		return getClass().getName() + "." + this.getId();
	}

    public Integer getRecommendType() {
        return recommendType;
    }

    public void setRecommendType(Integer recommendType) {
        this.recommendType = recommendType;
    }
}