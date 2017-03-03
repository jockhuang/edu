package cn.chineseall.model.org;

// Generated 2013-4-10 17:00:54 by Hibernate Tools 3.6.0

import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * OrgBook generated by hbm2java
 */
public class OrgBook extends BaseEntity {

    private Long id;              //流水号
    private Long orgTreeId;       //机构树ID
    private long bookId;          //图书ID
    private int isHidden;         //是否隐藏
    private int batchNumber;      //配书批次号
    private Date creationTime;    //入库时间
    
    //表后缀
    private String tablePostFix;

    public OrgBook() {
    }

    public OrgBook(long bookId, int isHidden, int batchNumber) {
        this.bookId = bookId;
        this.isHidden = isHidden;
        this.batchNumber = batchNumber;
    }

    public OrgBook(Long orgTreeId, long bookId, int isHidden, int batchNumber, Date creationTime) {
        this.orgTreeId = orgTreeId;
        this.bookId = bookId;
        this.isHidden = isHidden;
        this.batchNumber = batchNumber;
        this.creationTime = creationTime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgTreeId() {
        return this.orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public long getBookId() {
        return this.bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getIsHidden() {
        return this.isHidden;
    }

    public void setIsHidden(int isHidden) {
        this.isHidden = isHidden;
    }

    public int getBatchNumber() {
        return this.batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
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

    public String getTablePostFix() {
        return tablePostFix;
    }

    public void setTablePostFix(String tablePostFix) {
        this.tablePostFix = tablePostFix;
    }

}