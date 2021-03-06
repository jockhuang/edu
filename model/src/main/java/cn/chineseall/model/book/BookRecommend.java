package cn.chineseall.model.book;

// Generated 2013-4-10 17:00:54 by Hibernate Tools 3.6.0

import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * BookRecommend generated by hbm2java
 */
public class BookRecommend extends BaseEntity {

    private Long id;
    private long bookId;
    private Long userId;
    private String comment;
    private Date creationTime;
    private Integer recommendToFriends;
    private Integer recommendToMyOrg;

    public BookRecommend() {
    }

    public BookRecommend(long bookId) {
        this.bookId = bookId;
    }

    public BookRecommend(long bookId, Long userId, String comment, Date creationTime, Integer recommendToFriends, Integer recommendToMyOrg) {
        this.bookId = bookId;
        this.userId = userId;
        this.comment = comment;
        this.creationTime = creationTime;
        this.recommendToFriends = recommendToFriends;
        this.recommendToMyOrg = recommendToMyOrg;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getBookId() {
        return this.bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getRecommendToFriends() {
        return this.recommendToFriends;
    }

    public void setRecommendToFriends(Integer recommendToFriends) {
        this.recommendToFriends = recommendToFriends;
    }

    public Integer getRecommendToMyOrg() {
        return this.recommendToMyOrg;
    }

    public void setRecommendToMyOrg(Integer recommendToMyOrg) {
        this.recommendToMyOrg = recommendToMyOrg;
    }

    /**
     * @see cn.chineseall.model.BaseEntity#getKeyword()
     */
    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }
}
