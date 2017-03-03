package cn.chineseall.model.eduyun;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class EduUserOrders extends BaseEntity {
    
    private static final long serialVersionUID = -2663855555536179681L;
    
    private Long id;
    private String ordersNo;
    private Date createTime;
    private Long userId;
    private Integer price;
    private Integer type;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrdersNo() {
        return ordersNo;
    }

    public void setOrdersNo(String ordersNo) {
        this.ordersNo = ordersNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
