package cn.chineseall.model.book;

import cn.chineseall.model.BaseEntity;

// Generated 2013-4-10 17:00:54 by Hibernate Tools 3.6.0

/**
 * Level generated by hbm2java
 */
public class Level extends BaseEntity {

    private Integer id;
    private String name;
    private Integer state;
    private Integer sort;

    public Level() {
    }

    public Level(String name, int state) {
        this.name = name;
        this.state = state;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @see cn.chineseall.model.BaseEntity#getKeyword()
     */
    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return this.getClass().getName()+"."+this.getId();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
