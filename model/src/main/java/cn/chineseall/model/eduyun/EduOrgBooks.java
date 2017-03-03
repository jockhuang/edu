package cn.chineseall.model.eduyun;

import cn.chineseall.model.BaseEntity;

public class EduOrgBooks extends BaseEntity {
    
    private static final long serialVersionUID = 4076835815490083745L;
    
    private String id;
    private String orgId;
    private String bookId;

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
