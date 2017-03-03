package cn.chineseall.model.book;

import cn.chineseall.model.BaseEntity;

public class BookSort extends BaseEntity {

    private static final long serialVersionUID = -2635758026150171325L;

    private Integer id;
    private String name;
    private String code;
    private String serialNumber;

    @Override
    public String getKeyword() {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

}
