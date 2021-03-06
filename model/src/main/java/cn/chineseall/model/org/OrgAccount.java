package cn.chineseall.model.org;

// Generated 2013-4-10 17:00:54 by Hibernate Tools 3.6.0

import java.math.BigDecimal;
import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * OrgAccount generated by hbm2java
 */
public class OrgAccount extends BaseEntity {

    private long orgTreeId;
    private BigDecimal totalAmount;
    private BigDecimal consumption;
    private BigDecimal remain;
    private Date validDate;
    private Date expiredDate;
    private Integer maxUserCount;
    private Date modifyDate;
    private Integer auditflag;
    private Integer orgCurrency;
    private Integer ipsetting;

    public OrgAccount() {
    }

    public OrgAccount(long orgTreeId, BigDecimal totalAmount, BigDecimal consumption, BigDecimal remain) {
        this.orgTreeId = orgTreeId;
        this.totalAmount = totalAmount;
        this.consumption = consumption;
        this.remain = remain;
    }

    public OrgAccount(long orgTreeId, BigDecimal totalAmount, BigDecimal consumption, BigDecimal remain,
            Date validDate, Date expiredDate, Integer maxUserCount, Date modifyDate, Integer auditflag,
            Integer orgCurrency, Integer ipsetting) {
        this.orgTreeId = orgTreeId;
        this.totalAmount = totalAmount;
        this.consumption = consumption;
        this.remain = remain;
        this.validDate = validDate;
        this.expiredDate = expiredDate;
        this.maxUserCount = maxUserCount;
        this.modifyDate = modifyDate;
        this.auditflag = auditflag;
        this.orgCurrency = orgCurrency;
        this.ipsetting = ipsetting;
    }

    public long getOrgTreeId() {
        return this.orgTreeId;
    }

    public void setOrgTreeId(long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getConsumption() {
        return this.consumption;
    }

    public void setConsumption(BigDecimal consumption) {
        this.consumption = consumption;
    }

    public BigDecimal getRemain() {
        return this.remain;
    }

    public void setRemain(BigDecimal remain) {
        this.remain = remain;
    }

    public Date getValidDate() {
        return this.validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Date getExpiredDate() {
        return this.expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Integer getMaxUserCount() {
        return this.maxUserCount;
    }

    public void setMaxUserCount(Integer maxUserCount) {
        this.maxUserCount = maxUserCount;
    }

    public Date getModifyDate() {
        return this.modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getAuditflag() {
        return this.auditflag;
    }

    public void setAuditflag(Integer auditflag) {
        this.auditflag = auditflag;
    }

    public Integer getOrgCurrency() {
        return this.orgCurrency;
    }

    public void setOrgCurrency(Integer orgCurrency) {
        this.orgCurrency = orgCurrency;
    }

    public Integer getIpsetting() {
        return this.ipsetting;
    }

    public void setIpsetting(Integer ipsetting) {
        this.ipsetting = ipsetting;
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
