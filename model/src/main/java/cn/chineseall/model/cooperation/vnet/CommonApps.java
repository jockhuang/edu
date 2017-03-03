package cn.chineseall.model.cooperation.vnet;

import cn.chineseall.model.BaseEntity;

public class CommonApps extends BaseEntity {
    
    private static final long serialVersionUID = -1429047634540574L;
    
    private Integer id;
    private String name;
    private String note;
    private Integer status;

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + getId();
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
