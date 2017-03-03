package cn.chineseall.model.eduyun;

import cn.chineseall.model.BaseEntity;

public class EduArea extends BaseEntity {
    
    
    private static final long serialVersionUID = 5983358642802890782L;
    
    private Integer id;
    private String name;
    private Integer level;
    private String code;

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + this.id;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
