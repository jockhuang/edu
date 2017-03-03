package cn.chineseall.model.org.vo;

import java.util.HashMap;

import cn.chineseall.model.vo.BaseQueryVo;

public class OrgBookQueryVo extends BaseQueryVo<HashMap>{
    
    private Long orgTreeId;
    
    private Long bookId;

    private String name;
    
    private String author;
    
    private String publisher;
    
    private Integer state;
    
    //表后缀
    private String tablePostFix;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getOrgTreeId() {
        return orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTablePostFix() {
        return tablePostFix;
    }

    public void setTablePostFix(String tablePostFix) {
        this.tablePostFix = tablePostFix;
    }
    
}
