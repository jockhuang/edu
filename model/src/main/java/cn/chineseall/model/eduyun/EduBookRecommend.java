package cn.chineseall.model.eduyun;

import cn.chineseall.model.BaseEntity;

public class EduBookRecommend extends BaseEntity {
	/**
	 * @author MR-ZHAO
	 */
	private static final long serialVersionUID = -1654032416895536570L;
	
	private Long id;
	private Integer type;
	private Integer sortValue;
	private Integer status;
	private Long bookId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSortValue() {
		return sortValue;
	}

	public void setSortValue(Integer sortValue) {
		this.sortValue = sortValue;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}

}