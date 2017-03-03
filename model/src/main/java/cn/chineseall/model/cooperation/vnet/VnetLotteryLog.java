package cn.chineseall.model.cooperation.vnet;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class VnetLotteryLog extends BaseEntity {
	
	/**
	 * @author MR-ZHAO
	 */
	private static final long serialVersionUID = 2334645856297945121L;
	private Long id;
	private Long userId;
	private Date createTime;
	private Long prizeId;
	private Integer status;
	private Integer isHide;
	@Override
	public String getKeyword() {
		return null;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getPrizeId() {
		return prizeId;
	}
	public void setPrizeId(Long prizeId) {
		this.prizeId = prizeId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIsHide() {
		return isHide;
	}
	public void setIsHide(Integer isHide) {
		this.isHide = isHide;
	}
}
