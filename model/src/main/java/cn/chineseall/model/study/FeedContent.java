package cn.chineseall.model.study;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;;

@Document(collection="FeedContent")
public class FeedContent implements Serializable {

    private static final long serialVersionUID = 1793601260912059455L;

    private String id;
    
    private Long userId;
    
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
  
}
