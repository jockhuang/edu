package cn.chineseall.model.book;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class Book extends BaseEntity {

    private static final long serialVersionUID = 328471404401579328L;

    private Long id;
    private String bookNumber;
    private String name;
    private String firstLetter;
    private String author;
    private String publisher;
    private String publishDate;
    private String isbn;
    private String picPath;
    private String bookUrl;
    private String score;
    private Integer userRange;
    private Integer categoryIdZt;
    private String sortCode;
    private Integer txtPages;
    private Integer pdfPages;
    private Integer jpgPages;
    private Integer bookCurrency;
    private Integer state;
    private Date dueDate;
    private Long assetsId;
    private Date creationTime;
    private Integer from;
    private Integer period;
    private Integer levelId;
    private Integer isNew;
    private Integer isRecommend;
    private Date onshelfTime;
    private Date downShelfTime;

    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
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

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getUserRange() {
        return userRange;
    }

    public void setUserRange(Integer userRange) {
        this.userRange = userRange;
    }

    public Integer getCategoryIdZt() {
        return categoryIdZt;
    }

    public void setCategoryIdZt(Integer categoryIdZt) {
        this.categoryIdZt = categoryIdZt;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
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

    public Integer getBookCurrency() {
        return bookCurrency;
    }

    public void setBookCurrency(Integer bookCurrency) {
        this.bookCurrency = bookCurrency;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Long getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(Long assetsId) {
        this.assetsId = assetsId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Date getOnshelfTime() {
        return onshelfTime;
    }

    public void setOnshelfTime(Date onshelfTime) {
        this.onshelfTime = onshelfTime;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Date getDownShelfTime() {
        return downShelfTime;
    }

    public void setDownShelfTime(Date downShelfTime) {
        this.downShelfTime = downShelfTime;
    }

}

