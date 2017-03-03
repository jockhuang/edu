package cn.chineseall.model.book;

import cn.chineseall.model.BaseEntity;

public class BookStatistics extends BaseEntity {

	private Long bookId;
	private Long clickCount = 0L;
	private Long readCount = 0L;
	private Long commentCount = 0L;
	private Long collectCount = 0L;
	private Long recommendCount = 0L;
	private Long readUserCount = 0L;
	private String stars = "0.0";

	@Override
	public String getKeyword() {
		return null;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getClickCount() {
		return clickCount;
	}

	public void setClickCount(Long clickCount) {
		this.clickCount = clickCount;
	}

	public Long getReadCount() {
		return readCount;
	}

	public void setReadCount(Long readCount) {
		this.readCount = readCount;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public Long getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(Long collectCount) {
		this.collectCount = collectCount;
	}

	public Long getRecommendCount() {
		return recommendCount;
	}

	public void setRecommendCount(Long recommendCount) {
		this.recommendCount = recommendCount;
	}

	public Long getReadUserCount() {
		return readUserCount;
	}

	public void setReadUserCount(Long readUserCount) {
		this.readUserCount = readUserCount;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	private static final long serialVersionUID = -194361419666529069L;
}
