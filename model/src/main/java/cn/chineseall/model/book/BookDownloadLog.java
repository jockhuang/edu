package cn.chineseall.model.book;

// Generated 2013-4-10 17:00:54 by Hibernate Tools 3.6.0

import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * BookDownloadLog generated by hbm2java
 */
public class BookDownloadLog extends BaseEntity {

    private Integer id;
    private Long orgTreeId;
    private Long userId;
    private Long bookId;
    private Date downloadDate;
    private Integer bookType;

    public BookDownloadLog() {
    }

    public BookDownloadLog(Long orgTreeId, Long userId, Long bookId, Date downloadDate, Integer bookType) {
        this.orgTreeId = orgTreeId;
        this.userId = userId;
        this.bookId = bookId;
        this.downloadDate = downloadDate;
        this.bookType = bookType;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrgTreeId() {
        return this.orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return this.bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Date getDownloadDate() {
        return this.downloadDate;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }

    public Integer getBookType() {
        return this.bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
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
