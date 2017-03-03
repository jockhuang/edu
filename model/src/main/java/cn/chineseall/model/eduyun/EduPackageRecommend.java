package cn.chineseall.model.eduyun;

import cn.chineseall.model.BaseEntity;

public class EduPackageRecommend extends BaseEntity {
    private static final long serialVersionUID = 7642858653086113179L;
    private String id;
    private Long packageId;
    private Integer type;
    private Integer sortValue;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSortValue() {
        return sortValue;
    }

    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + this.id;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }
}
