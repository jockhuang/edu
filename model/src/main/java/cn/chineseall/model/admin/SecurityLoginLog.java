package cn.chineseall.model.admin;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class SecurityLoginLog extends BaseEntity {

    private static final long serialVersionUID = 6679358261561434359L;

    private Integer id;
    private Integer userId;
    private String name;
    private String deptName;
    private Date loginTime;
    private String ip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }
}
