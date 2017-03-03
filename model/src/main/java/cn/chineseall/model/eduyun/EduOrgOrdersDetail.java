package cn.chineseall.model.eduyun;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class EduOrgOrdersDetail extends BaseEntity {
    
    private static final long serialVersionUID = -8928323057075677376L;
    
    private String id;
    private String orgOrdersId;
    private String packageId;
    private Date createTime;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgOrdersId() {
        return orgOrdersId;
    }

    public void setOrgOrdersId(String orgOrdersId) {
        this.orgOrdersId = orgOrdersId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
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

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + this.id;
    }
}
