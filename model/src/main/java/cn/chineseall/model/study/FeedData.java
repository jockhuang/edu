package cn.chineseall.model.study;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import cn.chineseall.model.BaseEntity;

@Document(collection="FeedData")
public class FeedData extends BaseEntity {

    private static final long serialVersionUID = 6740148660484985806L;
    
    private String id;
    
    //发送人id
    private Long senderId;
    
    //接收人id
    private Long receiverId;
    
    private String userImg;
    
    //类型
    private Integer type;
    
    //条目id
    private Long itemId;
    
    //发送人用户名
    private String userName;
    
    //标题
    private String title;
    
    private String content;
    
    //发布时间
    private Date createTime;
    
    //来自于(活动、)
    private String from;
    
    //来自于链接
    private String fromLink;
    
    //回复链接地址
    private String replayLink;
    
    //如果有图书的话需要有封面
    private String bookCover;
    
    //推荐链接地址
    private List<HashMap<String, Object>> recommendList;

    // 单条数据回复数(针对书评数量、活动下作品数)
 	private Integer replayCount;

 	// 最后刷新回复数时间
 	private Long lastFlushReplayCountTime;
    
    @Override
    public String getKeyword() {
        return null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<HashMap<String, Object>> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<HashMap<String, Object>> recommendList) {
        this.recommendList = recommendList;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromLink() {
        return fromLink;
    }

    public void setFromLink(String fromLink) {
        this.fromLink = fromLink;
    }

    public String getReplayLink() {
        return replayLink;
    }

    public void setReplayLink(String replayLink) {
        this.replayLink = replayLink;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

	public Integer getReplayCount() {
		return replayCount;
	}

	public void setReplayCount(Integer replayCount) {
		this.replayCount = replayCount;
	}

	public Long getLastFlushReplayCountTime() {
		return lastFlushReplayCountTime;
	}

	public void setLastFlushReplayCountTime(Long lastFlushReplayCountTime) {
		this.lastFlushReplayCountTime = lastFlushReplayCountTime;
	}
    
}
