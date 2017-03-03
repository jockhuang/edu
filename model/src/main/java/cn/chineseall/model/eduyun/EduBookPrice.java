package cn.chineseall.model.eduyun;

import cn.chineseall.model.BaseEntity;

public class EduBookPrice extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6150605247979511542L;
	private Long bookId;
	private Integer price;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}

}