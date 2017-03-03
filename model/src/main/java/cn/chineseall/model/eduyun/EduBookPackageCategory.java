package cn.chineseall.model.eduyun;

import cn.chineseall.model.BaseEntity;

public class EduBookPackageCategory extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8866284367991910745L;
	private Long id;
	private String name;
	private Integer state;
	private String code;

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
