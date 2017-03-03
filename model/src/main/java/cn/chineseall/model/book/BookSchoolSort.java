package cn.chineseall.model.book;

import cn.chineseall.model.BaseEntity;

public class BookSchoolSort extends BaseEntity {
    private static final long serialVersionUID = -5765755275708010565L;
    
    private Integer id;
    private String name;
    private String code;
    private Integer level;
    private Integer sortNo;
    private Integer parentId;
    private String initial;
    @Override
    public String getKeyword() {
        return this.getClass().getName()+"."+this.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}
    
}
