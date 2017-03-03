package cn.chineseall.model.study;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserFeed")
public class UserFeed implements Serializable{

    private static final long serialVersionUID = 829153460149574962L;
    
    //发送人id
    private Long senderId;
    
    //接收人id
    private Long receiverId;
    
    //feed类型
    private Integer type;
    
    //数据id
    private Long itemId;
    
    //存放feed所有html内容
    private String feedId;
    
    private Long createTime;
    
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

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
