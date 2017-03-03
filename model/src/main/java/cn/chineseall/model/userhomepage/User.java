package cn.chineseall.model.userhomepage;

import cn.chineseall.model.user.UserAccount;
import cn.chineseall.model.user.vo.UserInfo;

public class User {

	public User() {
	}

	public User(UserAccount account) {
		userId = account.getUserId();
		displayName = account.getDisplayName();
		score = account.getScore();
	}

	public User(UserInfo userInfo) {
		userId = userInfo.getUserId();
		displayName = userInfo.getDisplayName();
		score = userInfo.getScore();
	}

	private Long userId;

	private String displayName;

	private Integer score;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
