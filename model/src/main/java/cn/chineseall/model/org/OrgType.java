package cn.chineseall.model.org;

import cn.chineseall.model.BaseEntity;

public class OrgType extends BaseEntity {

    private static final long serialVersionUID = -4172205707727598805L;

    private Integer id;
    private String name;
    private Integer state;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
