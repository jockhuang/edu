package cn.chineseall.model.admin;

import cn.chineseall.model.BaseEntity;

public class SecurityWorkGroup extends BaseEntity {

    private static final long serialVersionUID = -5653969924100361852L;

    private Integer id;
    private String name;
    private String note;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }
}
