package cn.chineseall.model.activity;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class AcRecommend extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5414117651045579860L;
	private Long id;
	private Long acId;
	private String name;
	private String logo;
	private String directName;
	private Date recommendTime;
	private Long orgTreeId;
	private Long sort;
	private Integer state;
	private String description;

	public AcRecommend() {
		super();
	}

	public AcRecommend(Long id, Long acId, String name, String logo,
			String directName, Date recommendTime, Long orgTreeId, Long sort,
			Integer state) {
		super();
		this.id = id;
		this.acId = acId;
		this.name = name;
		this.logo = logo;
		this.directName = directName;
		this.recommendTime = recommendTime;
		this.orgTreeId = orgTreeId;
		this.sort = sort;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAcId() {
		return acId;
	}

	public void setAcId(Long acId) {
		this.acId = acId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDirectName() {
		return directName;
	}

	public void setDirectName(String directName) {
		this.directName = directName;
	}

	public Date getRecommendTime() {
		return recommendTime;
	}

	public void setRecommendTime(Date recommendTime) {
		this.recommendTime = recommendTime;
	}

	public Long getOrgTreeId() {
		return orgTreeId;
	}

	public void setOrgTreeId(Long orgTreeId) {
		this.orgTreeId = orgTreeId;
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String getKeyword() {
		return null;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}