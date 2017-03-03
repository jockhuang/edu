package cn.chineseall.model.audio;

import cn.chineseall.model.BaseEntity;

public class AudioBookInfo extends BaseEntity {

    private String bookId;
    private String bookName;
    private String state;
    private String typeName;
    private String authorName;
    private String description;
    private String imgUrl;
    private String announcerName;
    private Integer audioTimeScaleNo;
    private String audioSimpleDescription;
    private String authorSimpleDescription;
    private String announcerSimpleDescription;
    private Integer priceNo;
    private Integer audioNumber;
    private Integer shelves;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAnnouncerName() {
        return announcerName;
    }

    public void setAnnouncerName(String announcerName) {
        this.announcerName = announcerName;
    }

    public Integer getAudioTimeScaleNo() {
        return audioTimeScaleNo;
    }

    public void setAudioTimeScaleNo(Integer audioTimeScaleNo) {
        this.audioTimeScaleNo = audioTimeScaleNo;
    }

    public String getAudioSimpleDescription() {
        return audioSimpleDescription;
    }

    public void setAudioSimpleDescription(String audioSimpleDescription) {
        this.audioSimpleDescription = audioSimpleDescription;
    }

    public String getAuthorSimpleDescription() {
        return authorSimpleDescription;
    }

    public void setAuthorSimpleDescription(String authorSimpleDescription) {
        this.authorSimpleDescription = authorSimpleDescription;
    }

    public String getAnnouncerSimpleDescription() {
        return announcerSimpleDescription;
    }

    public void setAnnouncerSimpleDescription(String announcerSimpleDescription) {
        this.announcerSimpleDescription = announcerSimpleDescription;
    }

    public Integer getPriceNo() {
        return priceNo;
    }

    public void setPriceNo(Integer priceNo) {
        this.priceNo = priceNo;
    }

    public Integer getAudioNumber() {
        return audioNumber;
    }

    public void setAudioNumber(Integer audioNumber) {
        this.audioNumber = audioNumber;
    }

    public Integer getShelves() {
        return shelves;
    }

    public void setShelves(Integer shelves) {
        this.shelves = shelves;
    }

    private static final long serialVersionUID = -6777073348250576904L;

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }
}
