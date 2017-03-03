package cn.chineseall.model.admin;

import cn.chineseall.model.BaseEntity;

public class SecurityResource extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String url;
    private String name;
    private String note;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
