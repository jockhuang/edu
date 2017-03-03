package cn.chineseall.model.book;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class Purchase extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private Integer fromType;
    private String title;
    private Integer period;
    private String excelFilePath;
    private Integer num;
    private Date createTime;
    private Integer opratorId;
    private Integer auditStatus;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromType() {
        return fromType;
    }

    public void setFromType(Integer fromType) {
        this.fromType = fromType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getExcelFilePath() {
        return excelFilePath;
    }

    public void setExcelFilePath(String excelFilePath) {
        this.excelFilePath = excelFilePath;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOpratorId() {
        return opratorId;
    }

    public void setOpratorId(Integer opratorId) {
        this.opratorId = opratorId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String getKeyword() {
        return this.getClass().getName()+"."+this.getId();
    }
}
