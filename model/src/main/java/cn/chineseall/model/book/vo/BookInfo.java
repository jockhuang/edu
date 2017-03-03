package cn.chineseall.model.book.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cn.chineseall.model.BaseEntity;

@Document
public class BookInfo extends BaseEntity{

	/**
	 * 图书id
	 */
	@Id
	private Long bookId;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 简介
	 */
	private String intro;

	/**
	 * 评分
	 */
	private String score;

	/**
	 * 作者
	 */
	private String author;

	/**
	 * 出版社
	 */
	private String publisher;

	/**
	 * isbn编码
	 */
	private String isbn;

	/**
	 * 状态
	 */
	private Integer state;

	/**
	 * txt页码
	 */
	private Integer txtPages;

	/**
	 * pdf页码
	 */
	private Integer pdfPages;

	/**
	 * jpg页码
	 */
	private Integer jpgPages;
	
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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getTxtPages() {
		return txtPages;
	}

	public void setTxtPages(Integer txtPages) {
		this.txtPages = txtPages;
	}

	public Integer getPdfPages() {
		return pdfPages;
	}

	public void setPdfPages(Integer pdfPages) {
		this.pdfPages = pdfPages;
	}

	public Integer getJpgPages() {
		return jpgPages;
	}

	public void setJpgPages(Integer jpgPages) {
		this.jpgPages = jpgPages;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}

}
