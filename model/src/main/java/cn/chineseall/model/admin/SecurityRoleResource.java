package cn.chineseall.model.admin;

import cn.chineseall.model.BaseEntity;

public class SecurityRoleResource extends BaseEntity {

    private static final long serialVersionUID = -8091112273702942333L;
    private Integer id;
    private Integer resourceId;
    private Integer roleId;

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
