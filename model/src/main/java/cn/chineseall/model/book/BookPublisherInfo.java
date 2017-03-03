package cn.chineseall.model.book;

import cn.chineseall.model.BaseEntity;

public class BookPublisherInfo extends BaseEntity {
    private static final long serialVersionUID = 1864386835847617000L;

    private Long id;
    private String publisherName;
    private String logo;
    private String webSite;
    private String info;
    private String creationTime;

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + this.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
