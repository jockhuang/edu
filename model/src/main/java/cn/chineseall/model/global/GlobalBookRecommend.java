package cn.chineseall.model.global;

import cn.chineseall.model.BaseEntity;

public class GlobalBookRecommend extends BaseEntity {
    private static final long serialVersionUID = 7556237309527076726L;
    private Integer id;
    private Long bookId;
    private Integer type;
    private Integer orgTypeId;
    private String name;
    private String linkUrl;
    private String intro;
    private Integer sort;
    private String author;
    private String imageUrl;
    private String publisher;
    private Integer status;

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + this.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getOrgTypeId() {
        return orgTypeId;
    }

    public void setOrgTypeId(Integer orgTypeId) {
        this.orgTypeId = orgTypeId;
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
}
