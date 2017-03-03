package cn.chineseall.model.org;

import cn.chineseall.model.BaseEntity;

public class OrgTreeConf extends BaseEntity {
    
    
    private static final long serialVersionUID = -3325354893684300925L;
    
    private Long orgTreeId;
    private Integer isDelegate;
    private Integer isView;

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + this.getOrgTreeId();
    }

    public Long getOrgTreeId() {
        return orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public Integer getIsDelegate() {
        return isDelegate;
    }

    public void setIsDelegate(Integer isDelegate) {
        this.isDelegate = isDelegate;
    }

    public Integer getIsView() {
        return isView;
    }

    public void setIsView(Integer isView) {
        this.isView = isView;
    }
}
