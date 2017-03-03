package cn.chineseall.model.user;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class User extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6905572032082904095L;
	private Long id;
    private String userName;
    private String userPass;
    private Integer userState;
    private Date creationTime;
    //是否记住用户
    private boolean rememberMe;
    //0:用户登录   1:评委登录  2管理员
    private Integer type;
    
    private boolean isManager;
    
    private boolean isJury;

    //1:书香基教  2:书香高校
    private Integer platformId;
    
    @Override
    public String getKeyword() {
        return this.getClass().getName() + "." + getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean isManager) {
        this.isManager = isManager;
    }

    public boolean isJury() {
        return isJury;
    }

    public void setJury(boolean isJury) {
        this.isJury = isJury;
    }

}
