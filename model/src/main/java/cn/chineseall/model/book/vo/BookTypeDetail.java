package cn.chineseall.model.book.vo;

import cn.chineseall.model.BaseEntity;

public class BookTypeDetail extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3471534707843287309L;
	
	private Long bookId;          //图书ID
	private String name;          //显示图书名字
	private String author;        //显示作者名字
	private String publisher;     //显示出版社名字
	private String imgUrl;        //图书封面
	private String content;       //图书简介
	private String score;         //图书评分
	private String publishDate;   //出版时间
	private Integer isCollection;   //是否收藏

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	public void setPublishDate(String publishDate){
		this.publishDate = publishDate;
	}
    
	public String getPublishDate(){
		return publishDate;
	}
	
	public Integer getIsCollection() {
		return isCollection;
	}

	public void setIsCollection(Integer isCollection) {
		this.isCollection = isCollection;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}

}
