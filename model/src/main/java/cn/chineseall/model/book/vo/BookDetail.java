package cn.chineseall.model.book.vo;

import cn.chineseall.model.BaseEntity;
import cn.chineseall.model.book.Book;

public class BookDetail extends BaseEntity {

	private Book book;

	private String intro;

	private Long readCount;

	private Long collectionCount;

	private Long recommendCount;

	public Long getReadCount() {
		return readCount;
	}

	public void setReadCount(Long readCount) {
		this.readCount = readCount;
	}

	public Long getCollectionCount() {
		return collectionCount;
	}

	public void setCollectionCount(Long collectionCount) {
		this.collectionCount = collectionCount;
	}

	public Long getRecommendCount() {
		return recommendCount;
	}

	public void setRecommendCount(Long recommendCount) {
		this.recommendCount = recommendCount;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}

}
