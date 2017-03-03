package cn.chineseall.model.admin;

import cn.chineseall.model.BaseEntity;

public class SecurityUserRole extends BaseEntity {

    private static final long serialVersionUID = -7187231314176354190L;
    private Integer id;
    private Integer userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
