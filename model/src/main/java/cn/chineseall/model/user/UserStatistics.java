package cn.chineseall.model.user;

// Generated 2013-4-10 17:00:54 by Hibernate Tools 3.6.0

import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * UserStatistics generated by hbm2java select * from user_statistics where orgCode ='1447' order by 'readBookNum'
 * desc,userId desc limit 0,20 在service层将用户对应的信息加载到里面去
 */

public class UserStatistics extends BaseEntity {

    private long userId; //
    private Long orgTreeId; // 机构编码
    private Integer visitNum; // 书房被访问次数（页面刷新）
    private Integer dayVisitNum; // 一天书房被访问次数（页面刷新）
    private Integer weekVisitNum; // 一周书房被访问次数（页面刷新）
    private Integer readBookNum; // 阅读量(阅读多少本书) user_reading_book
    private Integer collectionNum; // 图书收藏数 user_collection
    private Integer bookCommentNum; // 书评数 book_comment
    private Integer friendsNum; // 书友数 user_concern
    private Integer loginNum; // 登录次数 user_login_detail
    private int todayLoginNum; // 当天登录次数
    private int weekLoginNum; // 周登录次数
    private Integer worksNum; // 作品总数 ac_works
    private Date updateTime; // 更新时间

    private Integer monthReadScore;//月阅读积分
    private Integer monthCommentScore;//月评论积分
    private Integer monthActivityScore;//月活动积分
    
    public UserStatistics() {
    }

    public UserStatistics(long userId, int todayLoginNum, int weekLoginNum) {
        this.userId = userId;
        this.todayLoginNum = todayLoginNum;
        this.weekLoginNum = weekLoginNum;
    }

    public UserStatistics(long userId, Long orgTreeId, Integer visitNum, Integer dayVisitNum, Integer weekVisitNum,
            Integer readBookNum, Integer collectionNum, Integer bookCommentNum, Integer friendsNum, Integer loginNum,
            int todayLoginNum, int weekLoginNum, Integer worksNum, Date updateTime) {
        this.userId = userId;
        this.orgTreeId = orgTreeId;
        this.visitNum = visitNum;
        this.dayVisitNum = dayVisitNum;
        this.weekVisitNum = weekVisitNum;
        this.readBookNum = readBookNum;
        this.collectionNum = collectionNum;
        this.bookCommentNum = bookCommentNum;
        this.friendsNum = friendsNum;
        this.loginNum = loginNum;
        this.todayLoginNum = todayLoginNum;
        this.weekLoginNum = weekLoginNum;
        this.worksNum = worksNum;
        this.updateTime = updateTime;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Long getOrgTreeId() {
        return this.orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public Integer getVisitNum() {
        return this.visitNum;
    }

    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
    }

    public Integer getDayVisitNum() {
        return this.dayVisitNum;
    }

    public void setDayVisitNum(Integer dayVisitNum) {
        this.dayVisitNum = dayVisitNum;
    }

    public Integer getWeekVisitNum() {
        return this.weekVisitNum;
    }

    public void setWeekVisitNum(Integer weekVisitNum) {
        this.weekVisitNum = weekVisitNum;
    }

    public Integer getReadBookNum() {
        return this.readBookNum;
    }

    public void setReadBookNum(Integer readBookNum) {
        this.readBookNum = readBookNum;
    }

    public Integer getCollectionNum() {
        return this.collectionNum;
    }

    public void setCollectionNum(Integer collectionNum) {
        this.collectionNum = collectionNum;
    }

    public Integer getBookCommentNum() {
        return this.bookCommentNum;
    }

    public void setBookCommentNum(Integer bookCommentNum) {
        this.bookCommentNum = bookCommentNum;
    }

    public Integer getFriendsNum() {
        return this.friendsNum;
    }

    public void setFriendsNum(Integer friendsNum) {
        this.friendsNum = friendsNum;
    }

    public Integer getLoginNum() {
        return this.loginNum;
    }

    public void setLoginNum(Integer loginNum) {
        this.loginNum = loginNum;
    }

    public int getTodayLoginNum() {
        return this.todayLoginNum;
    }

    public void setTodayLoginNum(int todayLoginNum) {
        this.todayLoginNum = todayLoginNum;
    }

    public int getWeekLoginNum() {
        return this.weekLoginNum;
    }

    public void setWeekLoginNum(int weekLoginNum) {
        this.weekLoginNum = weekLoginNum;
    }

    public Integer getWorksNum() {
        return this.worksNum;
    }

    public void setWorksNum(Integer worksNum) {
        this.worksNum = worksNum;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @see cn.chineseall.model.BaseEntity#getKeyword()
     */
    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public Integer getMonthReadScore() {
        return monthReadScore;
    }

    public void setMonthReadScore(Integer monthReadScore) {
        this.monthReadScore = monthReadScore;
    }

    public Integer getMonthCommentScore() {
        return monthCommentScore;
    }

    public void setMonthCommentScore(Integer monthCommentScore) {
        this.monthCommentScore = monthCommentScore;
    }

    public Integer getMonthActivityScore() {
        return monthActivityScore;
    }

    public void setMonthActivityScore(Integer monthActivityScore) {
        this.monthActivityScore = monthActivityScore;
    }

}
