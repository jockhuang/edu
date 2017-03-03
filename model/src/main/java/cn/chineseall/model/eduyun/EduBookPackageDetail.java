package cn.chineseall.model.eduyun;

import cn.chineseall.model.BaseEntity;

public class EduBookPackageDetail extends BaseEntity {
    
    private static final long serialVersionUID = -9154584370447004452L;
    
    private Long id;
    private Long packageId;
    private Long bookId;
    private Integer sortValue;
    private Integer status;

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + this.id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortValue() {
        return sortValue;
    }

    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }
}
