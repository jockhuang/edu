package cn.chineseall.model.user;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class UserReadGroupTopic extends BaseEntity {
   
    private static final long serialVersionUID = 2044937157918550894L;
   
    private Long id;
    private Long groupId;
    private String title;
    private String content;
    private Long userId;
    private Date createTime;
    private Integer replyNum;
    private Integer visitNum;
    private Integer isTop;
    private Integer isHot;
    private Date topTime;
    private Date hotTime;
    private Integer status;

    @Override
    public String getKeyword() {
        return this.getClass().getName()+"."+this.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public Integer getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Date getTopTime() {
        return topTime;
    }

    public void setTopTime(Date topTime) {
        this.topTime = topTime;
    }

    public Date getHotTime() {
        return hotTime;
    }

    public void setHotTime(Date hotTime) {
        this.hotTime = hotTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
}
