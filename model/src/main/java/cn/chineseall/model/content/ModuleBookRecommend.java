package cn.chineseall.model.content;

import cn.chineseall.model.BaseEntity;

public class ModuleBookRecommend extends BaseEntity {
    
    private static final long serialVersionUID = 281063088306810580L;
    
    private Integer id;
    private Long bookId;
    private Integer moduleId;
    private Integer status;

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

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}
