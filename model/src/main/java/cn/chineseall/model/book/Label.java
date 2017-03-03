package cn.chineseall.model.book;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class Label extends BaseEntity {

    private static final long serialVersionUID = -334335323629225875L;

    private Integer id;
    private String name;
    private Date createTime;
    private Integer state;

    @Override
    public String getKeyword() {
        return this.getClass().getName()+"."+getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
