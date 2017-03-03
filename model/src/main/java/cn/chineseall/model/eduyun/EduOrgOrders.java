package cn.chineseall.model.eduyun;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class EduOrgOrders extends BaseEntity {
    
    private static final long serialVersionUID = -8140329274399741011L;
    
    private String id;
    private String eduOrgId;
    private String ordersNo;
    private Integer price;
    private Date createTime;
    private String status;

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEduOrgId() {
        return eduOrgId;
    }

    public void setEduOrgId(String eduOrgId) {
        this.eduOrgId = eduOrgId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrdersNo() {
        return ordersNo;
    }

    public void setOrdersNo(String ordersNo) {
        this.ordersNo = ordersNo;
    }
}
