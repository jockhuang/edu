package cn.chineseall.model.eduyun;

import cn.chineseall.model.BaseEntity;

public class EduUserOrdersDetail extends BaseEntity {
    
    private static final long serialVersionUID = -8760341133323242369L;
    
    private Long id;
    private Long userOrdersId;
    private Long bookId;
    private Long packageId;
    private Integer price;
    private Integer status;

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + this.id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserOrdersId() {
        return userOrdersId;
    }

    public void setUserOrdersId(Long userOrdersId) {
        this.userOrdersId = userOrdersId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
