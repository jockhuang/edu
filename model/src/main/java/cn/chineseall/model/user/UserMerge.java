package cn.chineseall.model.user;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class UserMerge extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6905572032082904095L;
	private Long id;
	private Long userId;
    private String userName;
    private String userPass;
    private Integer userState;
    private Integer platformId;
    private Date creationTime;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}
    
}
