package cn.chineseall.model.book;

import cn.chineseall.model.BaseEntity;

public class BooksLabels extends BaseEntity {
    
    private static final long serialVersionUID = -2075074579028118795L;
    
    private Integer id;
    private Long bookId;
    private Integer labelId;
    private Integer state;

    @Override
    public String getKeyword() {
        return this.getClass().getName()+"."+getId();
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

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
