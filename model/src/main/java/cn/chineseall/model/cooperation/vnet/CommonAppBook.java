package cn.chineseall.model.cooperation.vnet;

import cn.chineseall.model.BaseEntity;

public class CommonAppBook extends BaseEntity {

    private static final long serialVersionUID = 1912920419898148664L;
    private Long id;
    private Integer appId;
    private String bookId;
    private Integer status;

    @Override
    public String getKeyword() {
        return this.getClass().getName()+"."+getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
