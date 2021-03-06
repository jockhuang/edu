package cn.chineseall.model.user;

// Generated 2013-4-10 17:00:54 by Hibernate Tools 3.6.0

import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * UserPointsDetail generated by hbm2java
 */
public class UserPointsDetail extends BaseEntity {

    private static final long serialVersionUID = -2776752249485316701L;
    
    private Long id;
    private long userId;
    private long orgTreeId;
    private Integer pointCount;
    private Integer operCode;
    private String operIp;
    private String operNote;
    private Date creationTime;

    public UserPointsDetail() {
    }

    public UserPointsDetail(long userId, long orgTreeId) {
        this.userId = userId;
        this.orgTreeId = orgTreeId;
    }

    public UserPointsDetail(long userId, long orgTreeId, Integer pointCount, Integer operCode, String operIp,
            String operNote, Date creationTime) {
        this.userId = userId;
        this.orgTreeId = orgTreeId;
        this.pointCount = pointCount;
        this.operCode = operCode;
        this.operIp = operIp;
        this.operNote = operNote;
        this.creationTime = creationTime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getOrgTreeId() {
        return this.orgTreeId;
    }

    public void setOrgTreeId(long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public Integer getPointCount() {
        return this.pointCount;
    }

    public void setPointCount(Integer pointCount) {
        this.pointCount = pointCount;
    }

    public Integer getOperCode() {
        return this.operCode;
    }

    public void setOperCode(Integer operCode) {
        this.operCode = operCode;
    }

    public String getOperIp() {
        return this.operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperNote() {
        return this.operNote;
    }

    public void setOperNote(String operNote) {
        this.operNote = operNote;
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
        return this.getClass().getName()+"."+this.getUserId()+"."+this.getOperCode();
    }

}
