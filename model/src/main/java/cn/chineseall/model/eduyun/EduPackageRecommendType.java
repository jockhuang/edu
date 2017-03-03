package cn.chineseall.model.eduyun;

import cn.chineseall.model.BaseEntity;

public class EduPackageRecommendType extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7076703847083092280L;
	
	private Long id;
	private String name;
	private Integer state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String getKeyword() {
		return this.getClass().getName() + "." + this.id;
	}

}
