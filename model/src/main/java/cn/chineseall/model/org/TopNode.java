package cn.chineseall.model.org;

import cn.chineseall.model.BaseEntity;

public class TopNode extends BaseEntity {

    private static final long serialVersionUID = -4301156940762418512L;

    private Integer id;
    private String name;
    private Integer state;
    private String domainName;

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

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + getId();
    }
}
