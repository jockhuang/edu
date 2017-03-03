package cn.chineseall.model.book;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class OutOrders extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 19020357053818189L;
	private Long id;
	private Long outOrderId;
	private Long bookId;
	private String name;
	private String publisher;
	private String publishDate;
	private String author;
	private String otherName;
	private String isbn;
	private String categoryId;
	private String fileSource;
	private Date createTime;
	private Integer state;
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getOutOrderId() {
		return outOrderId;
	}


	public void setOutOrderId(Long outOrderId) {
		this.outOrderId = outOrderId;
	}


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


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getOtherName() {
		return otherName;
	}


	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public String getFileSource() {
		return fileSource;
	}


	public void setFileSource(String fileSource) {
		this.fileSource = fileSource;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Integer getState() {
		return state;
	}


	public void setState(Integer state) {
		this.state = state;
	}


	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}
}