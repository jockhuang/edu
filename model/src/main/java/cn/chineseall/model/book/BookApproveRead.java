package cn.chineseall.model.book;

// Generated 2013-4-10 17:00:54 by Hibernate Tools 3.6.0

import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * BookApproveRead generated by hbm2java
 */
public class BookApproveRead extends BaseEntity {

    private Integer id;
    private long userId;
    private long bookId;
    private int audit;
    private Date creationTime;

    public BookApproveRead() {
    }

    public BookApproveRead(long userId, long bookId, int audit) {
        this.userId = userId;
        this.bookId = bookId;
        this.audit = audit;
    }

    public BookApproveRead(long userId, long bookId, int audit, Date creationTime) {
        this.userId = userId;
        this.bookId = bookId;
        this.audit = audit;
        this.creationTime = creationTime;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return this.bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getAudit() {
        return this.audit;
    }

    public void setAudit(int audit) {
        this.audit = audit;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * @see cn.chineseall.model.BaseEntity#getKeyword()
     */
    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}
