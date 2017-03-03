package cn.chineseall.model.cooperation.vnet;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class VnetPrize extends BaseEntity {
	/**
	 * @author MR-ZHAO
	 */
	private static final long serialVersionUID = 3707625318719329920L;
	private Long id;
    private Long userId;
    private String name;
    private String intro;
    private Date awardsTime;
    private Integer rank;
    private Integer status;
	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Date getAwardsTime() {
		return awardsTime;
	}
	public void setAwardsTime(Date awardsTime) {
		this.awardsTime = awardsTime;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
