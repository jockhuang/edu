package cn.chineseall.model.cooperation.vnet;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class VnetUserOrdersLog extends BaseEntity {
    
	private static final long serialVersionUID = 3065622276938964299L;
	
	private Long id;
    private Long userId;
    private String userCode;
    private Date startDate;
    private Date endDate;
    private Date createTime;
    private String transactionId;
    private Integer type;
    private Integer status;


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


	public String getUserCode() {
		return userCode;
	}


	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	@Override
    public String getKeyword() {
        return this.getClass().getName() + "." + getId();
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public String getTransactionId() {
        return transactionId;
    }


    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
