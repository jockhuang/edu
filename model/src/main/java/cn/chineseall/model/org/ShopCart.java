package cn.chineseall.model.org;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class ShopCart extends BaseEntity {

    private static final long serialVersionUID = -668534079842838938L;
    
    private Long id;
    private Date lastUpdateTime;
    private Long orgTreeId;
    private Long bookId;
    private Integer state;

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

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Long getOrgTreeId() {
        return orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
