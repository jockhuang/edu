package cn.chineseall.model.admin;

import cn.chineseall.model.BaseEntity;

public class SecurityRole extends BaseEntity {

    private static final long serialVersionUID = -121368304173004643L;

    private Integer id;
    private String name;
    private Integer enable;

    public SecurityRole() {

    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}
