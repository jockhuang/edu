package cn.chineseall.book.model;

import org.apache.solr.client.solrj.beans.Field;

public class SearchBook extends SearchModel {

    @Field("categoryId_0")
    String parentId;

    @Field("categoryName_0")
    String parentcategory;

    @Field("categoryId_1")
    String categoryId;

    @Field("categoryName_1")
    String category;
    
    @Field("org")
    Long[] org;

    @Field("tag")
    String[] tag;
    
    @Field("customcatId_0")
    String[] customcatId0;

    @Field("customcatName_0")
    String[] customcatName0;

    @Field("customcatId_1")
    String[] customcatId1;

    @Field("customcatName_1")
    String[] customcatName1;

    @Field("intro")
    String intro;

    @Field("bookNumber")
    String bookNumber;

    @Field("author")
    String author;

    @Field("publisher")
    String publisher;

    @Field("publishDate")
    String publishDate;

    @Field("firstLetter")
    String firstLetter;

    @Field("score")
    float score;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String[] getCustomcatId0() {
        return customcatId0;
    }

    public void setCustomcatId0(String[] customcatId0) {
        this.customcatId0 = customcatId0;
    }

    public String[] getCustomcatName0() {
        return customcatName0;
    }

    public void setCustomcatName0(String[] customcatName0) {
        this.customcatName0 = customcatName0;
    }

    public String[] getCustomcatId1() {
        return customcatId1;
    }

    public void setCustomcatId1(String[] customcatId1) {
        this.customcatId1 = customcatId1;
    }

    public String[] getCustomcatName1() {
        return customcatName1;
    }

    public void setCustomcatName1(String[] customcatName1) {
        this.customcatName1 = customcatName1;
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

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
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

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentcategory() {
        return parentcategory;
    }

    public void setParentcategory(String parentcategory) {
        this.parentcategory = parentcategory;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Long[] getOrg() {
        return org;
    }

    public void setOrg(Long[] org) {
        this.org = org;
    }

    public String[] getTag() {
        return tag;
    }

    public void setTag(String[] tag) {
        this.tag = tag;
    }

}
