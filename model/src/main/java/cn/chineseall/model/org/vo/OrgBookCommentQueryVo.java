package cn.chineseall.model.org.vo;

import java.util.HashMap;

import cn.chineseall.model.vo.BaseQueryVo;

public class OrgBookCommentQueryVo extends BaseQueryVo<HashMap> {

    public Long orgTreeId;
    
    public String name;
    
    public String author;
    
    public String publisher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getOrgTreeId() {
        return orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }
}
