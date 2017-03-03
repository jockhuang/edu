package cn.chineseall.model.userhomepage;

import cn.chineseall.model.user.vo.UserReadingDetail;

public class Book {
	
	public Book() {
		lastReadPage = 1;
	}

	public Book(cn.chineseall.model.book.Book book) {
		this();
		bookId = book.getId();
		name = book.getName();
		author = book.getAuthor();
	}

	public Book(UserReadingDetail detail) {
		this(detail.getBook());
		this.lastReadPage = detail.getReadingBook().getLastReadPage();
	}

	private Long bookId;

	private String name;
	
	private String author;
	
	private Integer lastReadPage;

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

	public Integer getLastReadPage() {
		return lastReadPage;
	}

	public void setLastReadPage(Integer lastReadPage) {
		this.lastReadPage = lastReadPage;
	}
	
}
