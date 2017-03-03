package cn.chineseall.model.cooperation.vnet;

import cn.chineseall.model.BaseEntity;

public class CommonCategoryBook extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private Long categoryId;
    private Long bookId;

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
