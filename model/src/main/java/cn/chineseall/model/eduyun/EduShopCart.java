package cn.chineseall.model.eduyun;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class EduShopCart extends BaseEntity {
    private static final long serialVersionUID = 5147319181043296916L;
    private Integer id;
    private Long userId;
    private Date createTime;
    private Long bookId;
    private Long packageId;
    private Integer price;

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + this.id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
