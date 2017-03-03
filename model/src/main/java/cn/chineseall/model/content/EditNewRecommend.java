package cn.chineseall.model.content;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class EditNewRecommend extends BaseEntity {
    
    private static final long serialVersionUID = 4236469354652102656L;
    
    private Long id;
    private Integer type;
    private Long orgTreeId;
    private Long bookId;
    private Date createTime;

    @Override
    public String getKeyword() {
        return getClass().getName() + "." + getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
