package cn.chineseall.model.eduyun;

import cn.chineseall.model.BaseEntity;

public class EduUserBook extends BaseEntity {
    
    private static final long serialVersionUID = 4239357973201137947L;
    
    private Long id;
    private Long userId;
    private Long bookId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
